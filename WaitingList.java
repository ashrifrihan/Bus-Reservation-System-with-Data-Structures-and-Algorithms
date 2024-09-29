public class WaitingList {

    private WaitingListNode front, rear;

    public WaitingList() {
        this.front = this.rear = null;
    }

    public void enqueue(ReservationEntry reservation) {
        WaitingListNode newNode = new WaitingListNode(reservation);
        if (rear == null) {
            front = rear = newNode;
        }
        else {
            rear.next = newNode;
            rear = newNode;
        }
        CommonClass.printLine("Added to waiting list: " + reservation.getCustomerName());

    }
    // Method to remove a reservation from the waiting list
    public ReservationEntry dequeue(){
        if (isEmpty()) {
            CommonClass.printLine("Waiting list is empty");
            return null;
        }
        ReservationEntry removedReservation = front.reservation;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        CommonClass.printLine("Removed from waiting list: " + removedReservation.getCustomerName());
        return removedReservation;
    }

    // Method to display the waiting list
    public void display(){
        if (isEmpty()){
            CommonClass.printLine("Waiting list is empty");
            return;
        }
        CommonClass.printLine("Waiting List");
        WaitingListNode current = front;
        while (current != null) {
            CommonClass.printLine(current.reservation.getCustomerName() + "");
            current = current.next;
        }
        CommonClass.printLine("\n");
    }

    // Method to check if waiting list is empty
    public boolean isEmpty(){
        return front == null;
    }

    // Method to get the front of the waiting list
    public WaitingListNode getFront(){
        return front;
    }
    
}
