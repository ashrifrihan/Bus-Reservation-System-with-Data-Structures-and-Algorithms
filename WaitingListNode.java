public class WaitingListNode {
    
    public ReservationEntry reservation;
    public WaitingListNode next;

    public WaitingListNode(ReservationEntry reservation) {
        this.reservation = reservation;
        this.next = null;
    }
}
