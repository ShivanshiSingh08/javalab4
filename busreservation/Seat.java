package busreservation;

public class Seat {
    private String seatClass;
    private boolean isReserved;

    public Seat(String seatClass) {
        this.seatClass = seatClass;
        this.isReserved = false;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void reserve() {
        this.isReserved = true;
    }

    public void cancelReservation() {
        this.isReserved = false;
    }
}
