

import java.util.Scanner;

import busreservation.Bus;

public class BusReservationSystem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create two buses
        Bus bus1 = new Bus(10);
        Bus bus2 = new Bus(10);

        // Menu for user interaction
        while (true) {
            System.out.println("\nBus Reservation System Menu:");
            System.out.println("1. Reserve a Seat");
            System.out.println("2. Display Available Seats");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Allow user to choose a bus for reservation
                    System.out.println("Choose a bus:");
                    System.out.println("1. Bus A");
                    System.out.println("2. Bus B");
                    int busChoice = sc.nextInt();

                    if (busChoice == 1) {
                        bus1.reserveSeat();
                    } else if (busChoice == 2) {
                        bus2.reserveSeat();
                    } else {
                        System.out.println("Invalid bus choice.");
                    }
                    break;
                case 2:
                    // Allow user to choose a bus for seat display
                    System.out.println("Choose a bus:");
                    System.out.println("1. Bus A");
                    System.out.println("2. Bus B");
                    int displayChoice = sc.nextInt();

                    if (displayChoice == 1) {
                        bus1.displayAvailableSeats();
                    } else if (displayChoice == 2) {
                        bus2.displayAvailableSeats();
                    } else {
                        System.out.println("Invalid bus choice.");
                    }
                    break;
                case 3:
                    // Allow user to choose a bus for reservation cancellation
                    System.out.println("Choose a bus:");
                    System.out.println("1. Bus A");
                    System.out.println("2. Bus B");
                    int cancelChoice = sc.nextInt();

                    if (cancelChoice == 1) {
                        bus1.cancelReservation();
                    } else if (cancelChoice == 2) {
                        bus2.cancelReservation();
                    } else {
                        System.out.println("Invalid bus choice.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting the program. Thank you!");
            }
        }
    }
}
