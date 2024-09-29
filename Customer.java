public class Customer {
    
    private String name, username, password, mobile, email, city;
    private int id, age;

    public Customer() {
    }

    public Customer(int id, String name, String username, String password, String mobile, String email, String city, int age) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.mobile = mobile;
        this.email = email;
        this.city = city;
        this.age = age;
    }

    // Getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }



    public static void saveCustomer(){
        int id = CommonClass.inputSetToInt("Enter the ID: ");
        String name = CommonClass.input("Enter the name: ");
        String username = CommonClass.input("Enter the username: ");
        String password = CommonClass.input("Enter the password: ");
        String mobile = CommonClass.input("Enter the mobile: ");
        String email = CommonClass.input("Enter the email: ");
        String city = CommonClass.input("Enter the city: ");
        int age = CommonClass.inputSetToInt("Enter the age: ");

        Customer c = new Customer(id, name, username, password, mobile, email, city, age);
        c.saveToDB();

        CommonClass.printLine("Saved successfully...\n");

        String choice = CommonClass.input("Do you want add another Customer ? (Y/y OR N/n) : ");
        CommonClass.printLine("\n");

        if(choice.equals("Y") || choice.equals("y")){
            saveCustomer();
        }
        else if (choice.equals("N") || choice.equals("n")){
            customerMenu();
        }
        else{
            CommonClass.printLine("Invalid Input !");
            customerMenu();
        }
    }

    public void saveToDB(){        
        DBClass.customers.add(this);
        view();
    }
    
    public void view(){
        CommonClass.printLine("Customer ID: " + getId() + ", Customer Name : " + this.getName() + ", Username : " + this.getUsername() + ", Password : " + this.getPassword() + ", Mobile No : " + this.getMobile() + ", Email : " + this.getEmail() + ", City : " + this.getCity() + ", Age : " + this.getAge());
    }
    public static void viewAll(){
        for (Customer c : DBClass.customers){
            c.view();
        }
    }

    public static void updateCustomer(){
        Customer c = searchCustomerByCustomerID();
        if(c != null){
            String name = CommonClass.input("Enter the Customer Name : ");
            c.setName(name);
            String username = CommonClass.input("Enter the Username : ");
            c.setUsername(username);
            String password = CommonClass.input("Enter the Password : ");
            c.setPassword(password);
            String mobile = CommonClass.input("Enter the Mobile No : ");
            c.setMobile(mobile);
            String email = CommonClass.input("Enter the Email : ");
            c.setEmail(email);
            String city = CommonClass.input("Enter the City : ");
            c.setCity(city);
            int age = CommonClass.inputSetToInt("Enter the Age : ");
            c.setAge(age);

            CommonClass.printLine("The Customer Name " + c.getId() + " is updated successfully...\n"); 
        }
        else{            
            CommonClass.printLine("Invalid Customer ID...\n");
        }
        customerMenu();
    }

    public static Customer searchCustomerByCustomerID(){        
        int id = CommonClass.inputSetToInt("Enter the Customer ID : ");
        for (Customer c : DBClass.customers) {
            if(c.getId() == id){
                return c;
            }         
        }
        return null;
    }
    public static void search(){
        Customer c = searchCustomerByCustomerID();
        if(c != null){
            c.view();
        }
        else{
            CommonClass.printLine("Invalid Customer ID...");
        }
        customerMenu();
    }

    public static void deleteCustomer(){
        int id = CommonClass.inputSetToInt("Enter the Customer ID : ");
        for (Customer c : DBClass.customers) {
            if(c.getId() == id){
                DBClass.customers.remove(c);
                CommonClass.printLine("The Customer ID " + id + " is deleted successfully...");
                break;
            }         
        }
        customerMenu();
    }


    public static void customerMenu(){
        CommonClass.printLine("-------------------------");
        CommonClass.printLine("Home > Customer");
        CommonClass.printLine("-------------------------\n");
        CommonClass.printLine("1 - View all Customer details.");
        CommonClass.printLine("2 - Add new Customer.");
        CommonClass.printLine("3 - Update Customer detail.");
        CommonClass.printLine("4 - Delete Customer detail.");
        CommonClass.printLine("5 - Search Customer detail.");
        CommonClass.printLine("6 - Go Back.");
        CommonClass.printLine("7 - Logout.");
        CommonClass.printLine("---------------------------\n");

        String choice = CommonClass.input("What is your Choice : ");
        CommonClass.print("\n");

        switch (choice) {
            case "1":
                viewAll();
                customerMenu();
                break;
            case "2":
                saveCustomer();
                break;
            case "3":
                updateCustomer();
                break;
            case "4":
                deleteCustomer();
                break;
            case "5":
                search();
                break;
            case "6":
                CommonClass.mainMenu();
                break;
            case "7":
                Run.mainMenu();
                break;
        
            default:
                CommonClass.print("Invalid Choice " + choice + "...\n");
                customerMenu();
                break;
        }

    }

    public static Customer searchCustomerByCustomerUsername(){        
        String username = CommonClass.input("Enter the username : ").trim();
        for (Customer c : DBClass.customers) {
            if(c.getUsername() == username){
                return c;
            }         
        }
        return null;
    }
    
}
