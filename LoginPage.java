import java.util.Scanner;

public class LoginPage {    
    
    private static Scanner scanner = new Scanner(System.in);

    

    public static boolean loginAdmin() {
        CommonClass.printLine("Enter admin username: ");
        String username = scanner.next();
        CommonClass.printLine("Enter admin password: ");
        String password = scanner.next();

        if (Admin.getUsername().equals(username) && Admin.getPassword().equals(password)) {
            CommonClass.printLine("Admin login successful!\n");
            CommonClass.mainMenu();
            return true;
        } else {
            CommonClass.printLine("Invalid admin username or password.");
            return false;
        }
    }

    public static boolean loginCustomer() {
        Customer c = Customer.searchCustomerByCustomerUsername();
    if (c == null) {
        CommonClass.printLine("Customer not found. Please check your username.");
        return false;
    }

    String password = CommonClass.input("Enter the password: ");
    if (c.getPassword().equals(password)) {
        CommonClass.printLine("Customer login successful!\n");
        // Proceed with your logic after successful login
        return true;
    } else {
        CommonClass.printLine("Invalid username or password.\n");
        return false;
    }
    }

}
