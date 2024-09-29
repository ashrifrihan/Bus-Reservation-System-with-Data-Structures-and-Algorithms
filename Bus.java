import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Bus {

    private int id;
    private String busNumber;
    private int totalSeats;
    private String startingPoint;
    private String endingPoint;
    private LocalTime startingTime;
    private float fare;
    private List<ReservationEntry> reservations;
    private WaitingList waitingList;

    public Bus() {
        this.reservations = new ArrayList<>();
        this.waitingList = new WaitingList();
    }

    public Bus(int id, String busNumber, int totalSeats, String startingPoint, String endingPoint, LocalTime startingTime, float fare) {
        this.busNumber = busNumber;
        this.totalSeats = totalSeats;
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
        this.startingTime = startingTime;
        this.fare = fare;
        this.reservations = new ArrayList<>();
        this.waitingList = new WaitingList();
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    public String getEndingPoint() {
        return endingPoint;
    }

    public void setEndingPoint(String endingPoint) {
        this.endingPoint = endingPoint;
    }

    public LocalTime getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(LocalTime startingTime) {
        this.startingTime = startingTime;
    }

    public float getFare() {
        return fare;
    }

    public void setFare(float fare) {
        this.fare = fare;
    }

    public List<ReservationEntry> getReservations() {
        return reservations;
    }

    public WaitingList getWaitingList() {
        return waitingList;
    }


    public static void saveBus(){
        int id = CommonClass.inputSetToInt("Enter the ID: ");
        String busNo = CommonClass.input("Enter the bus no: ");
        int seats = CommonClass.inputSetToInt("Enter the total seats: ");
        String startingPoint = CommonClass.input("Enter the starting point: ");
        String endingPoint = CommonClass.input("Enter the ending point: ");
        LocalTime startingTime = LocalTime.parse(CommonClass.input("Enter the starting time (HH:MM): "));
        float fare = CommonClass.inputFloat("Enter the fare: ");

        Bus b = new Bus(id, busNo, seats, startingPoint, endingPoint, startingTime, fare);
        b.saveToDB();

        CommonClass.printLine("Saved successfully...\n");

        String choice = CommonClass.input("Do you want add another Bus ? (Y/y OR N/n) : ");
        CommonClass.printLine("\n");

        if(choice.equals("Y") || choice.equals("y")){
            saveBus();
        }
        else if (choice.equals("N") || choice.equals("n")){
            busMenu();
        }
        else{
            CommonClass.printLine("Invalid Input !");
            busMenu();
        }
    }

    public void saveToDB(){        
        DBClass.buses.add(this);
        view();
    }
    
    public void view(){
        CommonClass.printLine("Bus ID: " + getId() + ", Bus No : " + this.getBusNumber() + ", Seats : " + this.getTotalSeats() + ", Starting Point : " + this.getStartingPoint() + ", Ending Point : " + this.getEndingPoint() + ", Starting Time : " + this.getStartingTime() + ", Fare : " + this.getFare());
    }
    public static void viewAll(){
        for (Bus b : DBClass.buses){
            b.view();
        }
    }

    public static void updateBus(){
        Bus b = searchBusByBusID();
        if(b != null){
            String busNo = CommonClass.input("Enter the Bus No : ");
            b.setBusNumber(busNo);
            int seats = CommonClass.inputSetToInt("Enter the Seats : ");
            b.setTotalSeats(seats);
            String startingPoint = CommonClass.input("Enter the Starting Point : ");
            b.setStartingPoint(startingPoint);
            String endingPoint = CommonClass.input("Enter the Ending Point : ");
            b.setEndingPoint(endingPoint);
            LocalTime startingTime = LocalTime.parse(CommonClass.input("Enter the Starting Time : "));
            b.setStartingTime(startingTime);
            float fare = CommonClass.inputFloat("Enter the Fare : ");
            b.setFare(fare);

            CommonClass.printLine("The Bus ID " + b.getId() + " is updated successfully...\n"); 
        }
        else{            
            CommonClass.printLine("Invalid Customer ID...\n");
        }
        busMenu();
    }

    public static Bus searchBusByBusID(){        
        int id = CommonClass.inputSetToInt("Enter the Bus ID : ");
        for (Bus b : DBClass.buses) {
            if(b.getId() == id){
                return b;
            }         
        }
        return null;
    }
    public static void search(){
        Bus b = searchBusByBusID();
        if(b != null){
            b.view();
        }
        else{
            CommonClass.printLine("Invalid Bus ID...");
        }
        busMenu();
    }

    public static void deleteBus(){
        int id = CommonClass.inputSetToInt("Enter the Bus ID : ");
        for (Bus b : DBClass.buses) {
            if(b.getId() == id){
                DBClass.buses.remove(b);
                CommonClass.printLine("The Bus ID " + id + " is deleted successfully...");
                break;
            }         
        }
        busMenu();
    }

    public static void busMenu(){
        CommonClass.printLine("-------------------------");
        CommonClass.printLine("Home > Bus");
        CommonClass.printLine("-------------------------\n");
        CommonClass.printLine("1 - View all Bus details.");
        CommonClass.printLine("2 - Add new Bus.");
        CommonClass.printLine("3 - Update Bus detail.");
        CommonClass.printLine("4 - Delete Bus detail.");
        CommonClass.printLine("5 - Search Bus detail.");
        CommonClass.printLine("6 - Go Back.");
        CommonClass.printLine("7 - Logout.");
        CommonClass.printLine("---------------------------\n");

        String choice = CommonClass.input("What is your Choice : ");
        CommonClass.print("\n");

        switch (choice) {
            case "1":
                viewAll();
                busMenu();
                break;
            case "2":
                saveBus();
                break;
            case "3":
                updateBus();
                break;
            case "4":
                deleteBus();
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
                busMenu();
                break;
        }

    }
    
}
