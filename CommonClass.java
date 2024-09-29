import java.util.Scanner;

public class CommonClass {

    public CommonClass(){

    }

    private static Scanner input = new Scanner(System.in);
    
    public static String input(String msg){
        print(msg);
        return input.nextLine();
    }

    public static int inputSetToInt(String msg){
        CommonClass.print(msg);
        return Integer.parseInt(input.nextLine());
    }

    public static float inputFloat(String msg){
        CommonClass.print(msg);
        return Float.parseFloat(input.nextLine());
    }

    public static void printLine(String message){
        System.out.println(message);
    }

    public static void print(String message){
        System.out.print(message);
    }

    public static void mainMenu(){

        printLine("\nWelcome Page");
        printLine("---------------------------------");
        
        printLine("Home");
        printLine("----------------");
        printLine("1 - Customer");
        printLine("2 - Bus");
        printLine("3 - Exit");
        printLine("----------------\n");

        String choice = input("What is your Choice ? ");

        switch (choice) {
            case "1":
                Customer.customerMenu();
                break;
            case "2":
                Bus.busMenu();
                break;
            case "3":
                System.exit(0);
                break;
        
            default:
                printLine("Invalid Choice " + choice + "...\n");
                mainMenu();
                break;
        }

    }
    

}
