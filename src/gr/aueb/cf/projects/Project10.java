package gr.aueb.cf.projects;

import java.util.Arrays;
import java.util.Scanner;

public class Project10 {
    final static int CHAR_TO_COLUMN_INDEX = 65;

    public static void main(String[] args) {
        int col;
        int row;
        boolean[][] theater = new boolean[30][12];
        boolean bookSuccessful;
        String userInput;
        Scanner in = new Scanner(System.in);

        initialize(theater);
        System.out.println("The position must be in the form \"CN\", where \"C\" is the column");
        System.out.println("and \"N\" is the number of the row. So, for example, \"C5\" is a valid seat.");
        System.out.println("Columns are between A and L and rows are between 1 and 30.");
        System.out.print("Enter the seat you want to book: ");
        userInput = in.nextLine().toUpperCase();

        if (!validChoice(userInput)) {
            System.out.println("Invalid seat.");
        } else {
            col = userInput.charAt(0);
            row = Integer.parseInt(userInput.substring(1));
            bookSuccessful = book(col, row, theater);

            if (bookSuccessful) {
                System.out.println("Seat successfully booked!");
            } else {
                System.out.println("Seat already booked!");
            }
        }

        print(theater);
    }

     public static void initialize(boolean[][] array) {
         for (boolean[] element : array) {
             Arrays.fill(element, false);
         }
    }

    public static boolean book(int col, int row, boolean[][] array) {
        if (!array[row - 1][col - CHAR_TO_COLUMN_INDEX]) {
            array[row - 1][col - CHAR_TO_COLUMN_INDEX] = true;
            return true;
        }

        return false;
    }

    public static boolean cancel(int col, int row, boolean[][] array) {
        if (array[row - 1][col - CHAR_TO_COLUMN_INDEX]) {
            array[row - 1][col - CHAR_TO_COLUMN_INDEX] = false;
            return true;
        }

        return false;
    }

    public static void print(boolean[][] array) {
        for (boolean[] item : array) {
            for (boolean b : item) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }

    public static boolean validChoice(String input) {
        int row;

        if ((input.charAt(0) < 'A') || (input.charAt(0) > 'L')) return false;

        try {
            row = Integer.parseInt(input.substring(1));
        } catch (NumberFormatException e) {
            return false;
        }

        if (row > 30 || row < 1) return false;

        return true;
    }

}
