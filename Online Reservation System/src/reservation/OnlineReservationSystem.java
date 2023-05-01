package reservation;
import java.util.Scanner;

public class OnlineReservationSystem {

	private static boolean[] seats = new boolean[10]; 

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. View Seat Map");
            System.out.println("2. Reserve Seat");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");

            int option = scanner.nextInt();

            switch (option) {

                case 1:
                    viewSeatChart();
                    break;

                case 2:
                	bookSeat();
                    break;

                case 3:
                	cancelBooking();
                    break;

                case 4:
                    System.exit(0);

                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private static void viewSeatChart() {
        System.out.println("\nCurrent Seat Map:");
        for (int i = 0; i < seats.length; i++) {
            if (seats[i]) {
                System.out.print("X "); 
            } else {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
    }

    private static void bookSeat() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter seat number (1-10): ");
        int seatNumber = scanner.nextInt();
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number!");
        } else if (seats[seatNumber - 1]) {
            System.out.println("Seat already reserved!");
        } else {
            seats[seatNumber - 1] = true; 
            System.out.println("Seat reserved successfully!");
        }
    }

    private static void cancelBooking() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter seat number (1-10): ");
        int seatNumber = scanner.nextInt();
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number!");
        } else if (!seats[seatNumber - 1]) {
            System.out.println("Seat not reserved!");
        } else {
            seats[seatNumber - 1] = false; 
            System.out.println("Reservation canceled!");
        }
    }

}
