import java.time.LocalDateTime;

public class ReservationEntry {

    private String customerName;
    private String customerMobile;
    private LocalDateTime reservationTime;
    private int seatNumber;

    public ReservationEntry (String customerName, String customerMobile, LocalDateTime reservationTime, int seatNumber){
        this.customerName = customerName;
        this.customerMobile = customerMobile;
        this.reservationTime = reservationTime;
        this.seatNumber = seatNumber;
    }

    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCustomerMobile() {
        return customerMobile;
    }
    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }
    public void setReservationTime(LocalDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    public int getSeatNumber() {
        return seatNumber;
    }
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
    
    @Override
    public String toString() {
        return "Reseravation Entry { Customer Name = " +customerName+ "\nCustomer Mobile = "+customerMobile+ "\nReservation Time = " +reservationTime+ "\nSeat NUmber = " +seatNumber+ " }";
    }
    
}
