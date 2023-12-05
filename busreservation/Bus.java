package busreservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface ReservationSystem {
    void reserveSeat();

    void displayAvailableSeats();
}

public class Bus implements ReservationSystem {
    private List<Seat> seats;
    private int totalSeats;

    public Bus(int totalSeats) {
        this.totalSeats = totalSeats;
        this.seats = new ArrayList<>();

        for (int i = 0; i < totalSeats / 2; i++) {
            seats.add(new Seat("Standard"));
        }

        for (int i = totalSeats / 2; i < totalSeats; i++) {
            seats.add(new Seat("Premium"));
        }
    }

    public void reserveSeat() {
        Scanner scanner = new Scanner(System.in);

        // Display available seats
        displayAvailableSeats();

        // Get user input for seat reservation
        System.out.print("Enter seat number to reserve: ");
        int seatNumber = scanner.nextInt();

        // Validate seat number
        if (seatNumber < 1 || seatNumber > totalSeats) {
            System.out.println("Invalid seat number. Please enter a valid seat number.");
            return;
        }

        Seat selectedSeat = seats.get(seatNumber - 1);

        // Check seat availability
        if (!selectedSeat.isReserved()) {
            selectedSeat.reserve(); // Reserve the seat
            System.out.println("Seat reserved successfully! Class: " + selectedSeat.getSeatClass());
        } else {
            System.out.println("Seat is already reserved. Please choose another seat.");
        }
    }

    public void displayAvailableSeats() {
        System.out.println("Available Seats:");
        for (int i = 0; i < totalSeats; i++) {
            Seat seat = seats.get(i);
            if (!seat.isReserved()) {
                System.out.println("Seat " + (i + 1) + " (" + seat.getSeatClass() + ")");
            }
        }
        System.out.println(); // Move to the next line for better readability
    }

    public void cancelReservation() {
        Scanner scanner = new Scanner(System.in);

        // Display reserved seats
        displayReservedSeats();

        // Get user input for seat cancellation
        System.out.print("Enter seat number to cancel reservation: ");
        int seatNumber = scanner.nextInt();

        // Validate seat number
        if (seatNumber < 1 || seatNumber > totalSeats) {
            System.out.println("Invalid seat number. Please enter a valid seat number.");
            return;
        }

        Seat selectedSeat = seats.get(seatNumber - 1);

        // Check if the seat is reserved
        if (selectedSeat.isReserved()) {
            selectedSeat.cancelReservation(); // Cancel the reservation
            System.out.println("Reservation canceled successfully for Seat " + seatNumber);
        } else {
            System.out.println("Seat is not reserved. No reservation to cancel.");
        }
    }

    public void displayReservedSeats() {
        System.out.println("Reserved Seats:");
        for (int i = 0; i < totalSeats; i++) {
            Seat seat = seats.get(i);
            if (seat.isReserved()) {
                System.out.println("Seat " + (i + 1) + " (" + seat.getSeatClass() + ")");
            }
        }
        System.out.println();
    }
}
