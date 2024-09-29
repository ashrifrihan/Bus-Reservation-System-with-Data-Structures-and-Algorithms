public class Run {   

    public static void main(String[] args) {
        mainMenu();
    }
    
    public static void mainMenu(){
        boolean status = false;

        while (!status) {
            CommonClass.printLine("Welcome Page");
            CommonClass.printLine("------------");
            CommonClass.printLine("1 - Login as Admin");
            CommonClass.printLine("2 - Login as Customer");
            CommonClass.printLine("3 - Exit");

            try {
                int choice = CommonClass.inputSetToInt("Enter the choice: ");


            switch (choice) {
                case 1:
                    status = LoginPage.loginAdmin();
                    break;
                case 2:
                    status = LoginPage.loginCustomer();
                    break;
                case 3:
                    System.exit(0);
                    break;
            
                default:
                    CommonClass.printLine("Invalid Choice");
                    break;
            }
            } catch (Exception e) {
                CommonClass.printLine(e.getMessage() + "\n");
            }
        }

        
    }

}
