import java.io.*;
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String loggedInUser = null;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Patient Registration");
            System.out.println("2. Appointment Scheduling");
            System.out.println("3. Billing");
            System.out.println("4. Staff Management");
            System.out.println("5. Inventory Management");
            System.out.println("6. Electronic Health Records (EHR)");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    patientRegistration();
                    break;
                case 2:
                    appointmentScheduling();
                    break;
                case 3:
                    billing();
                    break;
                case 4:
                    staffManagement();
                    break;
                case 5:
                    inventoryManagement();
                    break;
                case 6:
                    ehrManagement();
                    break;
                case 7:
                    System.out.println("Thank you for using the Hospital Management System. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    static void patientRegistration() {
        scanner.nextLine(); 
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter Contact Number: ");
        String contact = scanner.nextLine();

        String fileName = name.replace(" ", "_") + "_Patient.txt";
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileName))) {
            writer.println("Name: " + name);
            writer.println("Age: " + age);
            writer.println("Gender: " + gender);
            writer.println("Contact: " + contact);
            writer.println("Appointments:");
            System.out.println("Patient registered successfully!");
        } catch (IOException e) {
            System.out.println("Error saving patient details: " + e.getMessage());
        }
    }

    static void appointmentScheduling() {
        scanner.nextLine(); 
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Enter Doctor's Name: ");
        String doctor = scanner.nextLine();

        String fileName = name.replace(" ", "_") + "_Patient.txt";
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("Patient not found. Please register first.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             PrintWriter writer = new PrintWriter(new FileOutputStream(file, true))) {
            writer.println("Appointment: " + date + " with Dr. " + doctor);
            System.out.println("Appointment scheduled successfully!");
        } catch (IOException e) {
            System.out.println("Error scheduling appointment: " + e.getMessage());
        }
    }

    static void billing() {
        scanner.nextLine(); 
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Treatment Description: ");
        String treatment = scanner.nextLine();
        System.out.print("Enter Amount: ");
        double amount = scanner.nextDouble();

        String fileName = name.replace(" ", "_") + "_Bill.txt";
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileName, true))) {
            writer.println("Treatment: " + treatment);
            writer.println("Amount: " + amount);
            writer.println("---");
            System.out.println("Billing information saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving billing information: " + e.getMessage());
        }
    }

    static void staffManagement() {
        scanner.nextLine();
        System.out.println("\n--- Staff Management ---");
        System.out.println("1. Add Staff Member");
        System.out.println("2. View Staff Members");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); 

        if (choice == 1) {
            System.out.print("Enter Staff Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Role: ");
            String role = scanner.nextLine();
            System.out.print("Enter Contact Number: ");
            String contact = scanner.nextLine();

            try (PrintWriter writer = new PrintWriter(new FileOutputStream("Staff.txt", true))) {
                writer.println("Name: " + name);
                writer.println("Role: " + role);
                writer.println("Contact: " + contact);
                writer.println("---");
                System.out.println("Staff member added successfully!");
            } catch (IOException e) {
                System.out.println("Error adding staff member: " + e.getMessage());
            }
        } else if (choice == 2) {
            try (BufferedReader reader = new BufferedReader(new FileReader("Staff.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Error reading staff information: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid choice. Returning to main menu.");
        }
    }

    static void inventoryManagement() {
        scanner.nextLine(); 
        System.out.println("\n--- Inventory Management ---");
        System.out.println("1. Add Inventory Item");
        System.out.println("2. View Inventory");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); 

        if (choice == 1) {
            System.out.print("Enter Item Name: ");
            String itemName = scanner.nextLine();
            System.out.print("Enter Quantity: ");
            int quantity = scanner.nextInt();

            try (PrintWriter writer = new PrintWriter(new FileOutputStream("Inventory.txt", true))) {
                writer.println("Item: " + itemName);
                writer.println("Quantity: " + quantity);
                writer.println("---");
                System.out.println("Inventory item added successfully!");
            } catch (IOException e) {
                System.out.println("Error adding inventory item: " + e.getMessage());
            }
        } else if (choice == 2) {
            try (BufferedReader reader = new BufferedReader(new FileReader("Inventory.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Error reading inventory: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid choice. Returning to main menu.");
        }
    }

    static void ehrManagement() {
        scanner.nextLine(); 
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();

        String fileName = name.replace(" ", "_") + "_Patient.txt";
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("Patient not found. Please register first.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            System.out.println("\n--- Electronic Health Record ---");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading EHR: " + e.getMessage());
        }
    }
}
