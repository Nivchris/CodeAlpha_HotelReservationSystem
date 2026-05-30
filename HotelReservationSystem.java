import java.util.Scanner;

public class HotelReservationSystem {

    static Scanner sc = new Scanner(System.in);

    static int[] roomNumbers = {101, 102, 201, 202, 301};

    static String[] roomTypes = {
            "Standard",
            "Standard",
            "Deluxe",
            "Deluxe",
            "Suite"
    };

    static double[] roomPrices = {
            1500,
            1500,
            2500,
            2500,
            5000
    };

    static boolean[] booked = new boolean[5];

    static String[] customerNames = new String[5];

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("   HOTEL RESERVATION SYSTEM");
            System.out.println("=================================");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Bookings");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    viewRooms();
                    break;

                case 2:
                    bookRoom();
                    break;

                case 3:
                    cancelBooking();
                    break;

                case 4:
                    viewBookings();
                    break;

                case 5:
                    System.out.println("Thank you for visiting!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }

    public static void viewRooms() {

        System.out.println("\n========== ROOM LIST ==========");

        for (int i = 0; i < roomNumbers.length; i++) {

            String status;

            if (booked[i]) {
                status = "Booked";
            } else {
                status = "Available";
            }

            System.out.println(
                    "Room: " + roomNumbers[i]
                            + " | Type: " + roomTypes[i]
                            + " | Price: ₹" + roomPrices[i]
                            + " | Status: " + status);
        }
    }

    public static void bookRoom() {

        System.out.print("\nEnter room number: ");
        int room = sc.nextInt();

        for (int i = 0; i < roomNumbers.length; i++) {

            if (roomNumbers[i] == room) {

                if (booked[i]) {
                    System.out.println("Room already booked!");
                    return;
                }

                sc.nextLine();

                System.out.print("Enter customer name: ");
                customerNames[i] = sc.nextLine();

                System.out.println("\n========== PAYMENT ==========");
                System.out.println("Room Price: ₹" + roomPrices[i]);
                System.out.println("Payment Successful!");

                booked[i] = true;

                System.out.println("\nBooking Confirmed!");
                System.out.println("Customer: " + customerNames[i]);
                System.out.println("Room Number: " + roomNumbers[i]);
                System.out.println("Room Type: " + roomTypes[i]);

                return;
            }
        }

        System.out.println("Room not found!");
    }

    public static void cancelBooking() {

        System.out.print("\nEnter room number to cancel: ");
        int room = sc.nextInt();

        for (int i = 0; i < roomNumbers.length; i++) {

            if (roomNumbers[i] == room) {

                if (!booked[i]) {
                    System.out.println("This room is not booked.");
                    return;
                }

                booked[i] = false;
                customerNames[i] = null;

                System.out.println("Booking cancelled successfully!");

                return;
            }
        }

        System.out.println("Room not found!");
    }

    public static void viewBookings() {

        System.out.println("\n========== BOOKINGS ==========");

        boolean found = false;

        for (int i = 0; i < roomNumbers.length; i++) {

            if (booked[i]) {

                System.out.println(
                        "Customer: " + customerNames[i]
                                + " | Room: " + roomNumbers[i]
                                + " | Type: " + roomTypes[i]
                                + " | Price: ₹" + roomPrices[i]);

                found = true;
            }
        }

        if (!found) {
            System.out.println("No bookings available.");
        }
    }
}
