package com.ppy.pahadi_punjabi_yatra;

import com.ppy.pahadi_punjabi_yatra.model.Booking;
import com.ppy.pahadi_punjabi_yatra.model.Customer;
import com.ppy.pahadi_punjabi_yatra.model.Cab;
import com.ppy.pahadi_punjabi_yatra.model.Driver;
import com.ppy.pahadi_punjabi_yatra.service.booking.BookingService;
import com.ppy.pahadi_punjabi_yatra.service.customer.CustomerService;
import com.ppy.pahadi_punjabi_yatra.service.cab.CabService;
import com.ppy.pahadi_punjabi_yatra.service.driver.DriverService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class PahadiPunjabiYatraApplication {

	public static void main(String[] args) {
		SpringApplication.run(PahadiPunjabiYatraApplication.class, args);
	}

	@Bean
	CommandLineRunner run(CustomerService customerService,
						  CabService cabService, DriverService driverService, BookingService bookingService) {

		return args -> {

			Scanner scanner = new Scanner(System.in);
			int choice;

			do {
				System.out.println("\n===== Pahadi Punjabi Yatra =====");
				System.out.println("1. Register Customer");
				System.out.println("2. Get Available Cabs");
				System.out.println("3. Register New Cab");
				System.out.println("4. Register New Driver");
				System.out.println("5. Book Cabs");
				System.out.println("6. Assign Cab to Driver");
				System.out.println("7. Exit");
				System.out.print("Enter your choice: ");

				choice = scanner.nextInt();
				scanner.nextLine(); // consume newline

				switch (choice) {

					// 🔹 Register Customer
					case 1:
						Customer customer = new Customer();

						System.out.print("Enter Name: ");
						customer.setName(scanner.nextLine());

						System.out.print("Enter Email: ");
						customer.setEmail(scanner.nextLine());

						System.out.print("Enter Phone Number: ");
						customer.setPhone_number(scanner.nextLine());

						customer.setRegistrationDt(LocalDateTime.now());

						customerService.registerCustomer(customer);
						System.out.println("Customer Registered Successfully!");
						break;

					// 🔹 Get Available Cabs
					case 2:
						List<Cab> availableCabs = cabService.getAvailableCabs();

						if (availableCabs.isEmpty()) {
							System.out.println("No Cabs Available!");
						} else {
							System.out.println("Available Cabs:");
							for (Cab cab : availableCabs) {
								System.out.println("Cab ID: " + cab.getId()
										+ " | Model: " + cab.getModel()
										+ " | Number: " + cab.getRegistration_no()
										+ " | Status: " + cab.getStatus());
							}
						}
						break;

					// 🔹 Register New Cab
					case 3:
						Cab cab = new Cab();

						System.out.print("Enter Cab Number: ");
						cab.setRegistration_no(scanner.nextLine());

						System.out.print("Enter Vehicle Model Name: ");
						cab.setModel(scanner.nextLine());

						// New cab default status = AVAILABLE
						cab.setStatus("AVAILABLE");
						cabService.registerCabs(cab);

						System.out.print("Enter Driver ID to assign (or 0 to skip): ");
						Long driverId = scanner.nextLong();
						if(driverId!=0){
							System.out.println("Cab Id is : "+ cab.getId());
							if(cabService.assignDriverToCab(cab.getId(),driverId))
							{
								System.out.println("Driver assigned Successfully");

							}
						}

						System.out.println("Cab Registered Successfully!");
						break;


					case 4:

						Driver driver = new Driver();

						System.out.print("Enter Driver Name: ");
						driver.setName(scanner.nextLine());

						System.out.print("Enter Phone Number: ");
						driver.setPhoneNumber(scanner.nextLine());

						System.out.print("Enter License Number: ");
						driver.setLicenseNumber(scanner.nextLine());

						System.out.print("Enter Rating (example 4.5): ");
						driver.setRating(scanner.nextBigDecimal());
						scanner.nextLine(); // consume newline

						// Optional: assign cab if needed
						System.out.print("Enter Cab ID to assign (or 0 to skip): ");
						Long cabId = scanner.nextLong();
						scanner.nextLine();

						if (cabId != 0) {
							Cab cabi = cabService.getCabById(cabId);  // you must create this method
							driver.setCab(cabi);
						}

						driverService.addDriver(driver);

						System.out.println("Driver Registered Successfully!");
						break;

					case 5:
						Booking booking=new Booking();

						System.out.print("Enter Customer ID: ");
						Long customerId = scanner.nextLong();
						scanner.nextLine();
						if(customerId!=0){
						Customer cus=customerService.getCustomerById(customerId);
						booking.setCustomer(cus);
						}

						System.out.print("Enter Cab ID: ");
						Long cabIdi = scanner.nextLong();
						scanner.nextLine();

						if (cabIdi != 0) {
							Cab cabii = cabService.getCabById(cabIdi);  // you must create this method
							booking.setCab(cabii);
						}
						System.out.print("Enter Pickup Location: ");
						String pickupLocation = scanner.nextLine();

						System.out.print("Enter Dropoff Location: ");
						String dropoffLocation = scanner.nextLine();
						booking.setPickupLocation(pickupLocation);
						booking.setDropLocation(dropoffLocation);
						booking.setBookingTime(LocalDateTime.now());
						booking.setStatus("PENDING");
						booking.setFare(BigDecimal.valueOf(250.00));
						bookingService.bookCab(booking);
						System.out.println("Booking Created Successfully!");
						break;

					case 6:
						System.out.print("Enter Driver ID: ");
						Long driverIdi = scanner.nextLong();
						scanner.nextLine();

						Optional<Driver> drivery = driverService.getDriverById(driverIdi);
						if (drivery.isEmpty()) {
							System.out.println("Invalid Driver ID!");
							break;
						}
						System.out.println("Details are + " + drivery.get().getName());
						Cab currentCab = drivery.get().getCab();
						if (currentCab != null) {
							System.out.println("Driver already assigned to Cab ID: " + currentCab.getId());
							System.out.print("Do you want to reassign? (yes/no): ");
							String reassignChoice = scanner.nextLine();
							if (!reassignChoice.equalsIgnoreCase("yes")) {
								break;
							}
						}

						System.out.print("Enter new Cab ID to assign: ");
						Long cabIdForDriver = scanner.nextLong();
						scanner.nextLine();

						Cab newCab = cabService.getCabById(cabIdForDriver);
						if (newCab != null && newCab.getDriver() == null) {
							cabService.assignDriverToCab(cabIdForDriver, driverIdi);
							System.out.println("Driver assigned to Cab Successfully!");
						} else {
							System.out.println("Cab not available or already assigned!");
						}
						break;

					case 7:

						System.out.println("Exiting Application...");
						break;


					default:
						System.out.println("Invalid Choice!");
				}

			} while (choice != 6);

			scanner.close();
		};
	}
}