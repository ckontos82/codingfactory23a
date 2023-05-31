package gr.aueb.cf.projects;

import java.util.Arrays;
import java.util.Scanner;

/**
 * This class represents a simple theater booking system.
 *
 * @author Charalampos Kontos
 */
public class Project10 {
    //Represents the ASCII value of character 'A' to convert character to column index.
    final static int CHAR_TO_COLUMN_INDEX = 65;

    public static void main(String[] args) {
        final String QUIT = "q";
        final String BOOK = "b";
        final String CANCEL = "c";
        final String PRINT = "p";
        boolean[][] theater = new boolean[30][12];
        String userInput;
        Scanner in = new Scanner(System.in);

        initializeSeats(theater);
        do {
            System.out.println();
            displayMenu();
            userInput = in.nextLine().toLowerCase();

            switch (userInput) {
                case QUIT:
                    System.out.println("Bye!");
                    break;
                case BOOK:
                    do {
                        bookSeat(theater, in);
                        System.out.println("If you want to book another seat, enter 'y': ");
                    } while (in.nextLine().equalsIgnoreCase("y"));
                    break;
                case CANCEL:
                    do {
                        cancelSeat(theater, in);
                        System.out.println("If you want to cancel another booked seat, enter 'y': ");
                    } while (in.nextLine().equalsIgnoreCase("y"));
                    break;
                case PRINT:
                    printTheater(theater);
                    break;
                default:
                    System.out.println("Your choice is not valid.");
            }
        } while (!userInput.equals(QUIT));
    }

    /**
     * Display the main menu to the console.
     */
    public static void displayMenu() {
        System.out.println("Main Menu");
        System.out.println("Enter 'b' to book a seat.");
        System.out.println("Enter 'c' to cancel a seat.");
        System.out.println("Enter 'q' to quit the application.");
        System.out.println("Enter 'p' to print the theater.");
        System.out.print("Your choice: ");
    }

    /**
     * Initialize all seats of the theater to not booked (false).
     *
     * @param theater A 2D array representing the theater seats.
     */
    public static void initializeSeats(boolean[][] theater) {
        for (boolean[] row : theater) {
            Arrays.fill(row, false);
        }
    }

    /**
     * Books a seat chosen by the user in the theater.
     *
     * @param theater A 2D array representing the theater seats.
     * @param scanner A Scanner object for user input.
     */
    public static void bookSeat(boolean[][] theater, Scanner scanner) {
        String seatId;
        int row;
        int col;
        boolean bookSuccessful;

        System.out.println("Enter the seat to book in the format 'CN', " +
                "where 'C' is the column letter (A-L)," +
                "and 'N' is the row number (1-30). For example, 'C5' is a valid seat.");
        System.out.print("Your selection: ");
        seatId = scanner.nextLine().toUpperCase();

        if (!isValidSeat(seatId)) {
            System.out.println("Invalid seat.");
        } else {
            col = seatId.charAt(0);
            row = Integer.parseInt(seatId.substring(1));
            bookSuccessful = book(col, row, theater);

            if (bookSuccessful) {
                System.out.println("Seat successfully booked!");
            } else {
                System.out.println("Seat already booked!");
            }
        }
    }

    /**
     * Cancels a seat chosen by the user in the theater.
     *
     * @param theater A 2D array representing the theater seats.
     * @param scanner A Scanner object for user input.
     */
    public static void cancelSeat(boolean[][] theater, Scanner scanner) {
        String seatId;
        int row;
        int col;
        boolean cancelSuccessful;

        System.out.println("Enter the seat to cancel in the format 'CN', " +
                "where 'C' is the column letter (A-L)," +
                "and 'N' is the row number (1-30). For example, 'C5' is a valid seat.");
        System.out.print("Your selection: ");
        seatId = scanner.nextLine().toUpperCase();

        if (!isValidSeat(seatId)) {
            System.out.println("Invalid seat.");
        } else {
            col = seatId.charAt(0);
            row = Integer.parseInt(seatId.substring(1));
            cancelSuccessful = cancel(col, row, theater);

            if (cancelSuccessful) {
                System.out.println("Booking successfully canceled!");
            } else {
                System.out.println("Seat not booked!");
            }
        }
    }

    /**
     * Books a specific seat in the theater.
     *
     * @param col Column (seat) of the theater to book.
     * @param row Row of the theater to book.
     * @param theater A 2D array representing the theater seats.
     * @return true if the seat was successfully booked, false otherwise (if the seat was already booked).
     */
    public static boolean book(int col, int row, boolean[][] theater) {
        if (!theater[row - 1][col - CHAR_TO_COLUMN_INDEX]) {
            theater[row - 1][col - CHAR_TO_COLUMN_INDEX] = true;
            return true;
        }

        return false;
    }

    /**
     * Cancels a specific seat in the theater.
     *
     * @param col Column (seat) of the theater to cancel.
     * @param row Row of the theater to cancel.
     * @param theater A 2D array representing the theater seats.
     * @return true if the seat was successfully canceled, false otherwise (if the seat was not previously booked).
     */
    public static boolean cancel(int col, int row, boolean[][] theater) {
        if (theater[row - 1][col - CHAR_TO_COLUMN_INDEX]) {
            theater[row - 1][col - CHAR_TO_COLUMN_INDEX] = false;
            return true;
        }

        return false;
    }

    /**
     * Checks if a given seat identifier is valid.
     *
     * @param seatId The identifier of the seat to check.
     * @return true if the identifier is valid, false otherwise.
     */
    public static boolean isValidSeat(String seatId) {
        int row;

        if ((seatId.charAt(0) < 'A') || (seatId.charAt(0) > 'L')) return false;

        try {
            row = Integer.parseInt(seatId.substring(1));
        } catch (NumberFormatException e) {
            return false;
        }

        return row <= 30 && row >= 1;
    }

    /**
     * Prints the current state of the theater to the console.
     * Booked seats are marked with an 'X', available seats with '_'.
     *
     * @param theater A 2D array representing the theater seats.
     */
    public static void printTheater(boolean[][] theater) {
        System.out.println();
        System.out.println("Booked seats appear with X");
        System.out.print("    ");

        for (char c = 'A'; c <= 'L'; c++) {
            System.out.printf("%c ", c);
        }
        System.out.println();

        for (int i = 0; i < theater.length; i++) {
            System.out.printf("%02d| ", i + 1);
            for (int j = 0; j < theater[i].length; j++) {
                if (!theater[i][j]) {
                    System.out.print("_ ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
