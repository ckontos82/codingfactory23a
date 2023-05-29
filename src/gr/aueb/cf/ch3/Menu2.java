package gr.aueb.cf.ch3;

import java.util.Scanner;

/**
 * Displays a menu until the user inputs
 * 5 for exit.
 * If the choice is out of range
 * (i.e. greater than 5 or less than 1)
 * it displays an error message.
 *
 * 2nd solution
 *
 * @author Charalampos Kontos
 */
public class Menu2 {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        int keybrdInput = 0;
        final int INPUT = 1;
        final int ERASE = 2;
        final int UPDATE = 3;
        final int SEARCH = 4;
        final int EXIT = 5;

        do {
            System.out.println("Μενού επιλογής");
            System.out.println("1. Εισαγωγή");
            System.out.println("2. Διαγραφή");
            System.out.println("3. Ενημέρωση");
            System.out.println("4. Αναζήτηση");
            System.out.println("5. Έξοδος");
            System.out.print("Δώστε επιλογή: ");

            do {
                keybrdInput = key.nextInt();

                if ((keybrdInput > EXIT) || (keybrdInput < INPUT)) {
                    System.out.println("Η επιλογή δεν είναι σωστή.");
                    System.out.print("Παρακαλώ εισάγετε μία επιλογή από τις ανωτέρω (1 - 5): ");
                }
            } while ((keybrdInput > EXIT) || (keybrdInput < INPUT));

            if (keybrdInput == INPUT) {
                System.out.println("Eπιλέξατε εισαγωγή.");
            } else if (keybrdInput == ERASE) {
                System.out.println("Επιλέξατε διαγραφή.");
            } else if (keybrdInput == UPDATE) {
                System.out.println("Επιλέξατε ενημέρωση.");
            } else if (keybrdInput == SEARCH) {
                System.out.println("Επιλέξατε αναζήτηση.");
            } else {
                System.out.println("Έξοδος από το μενού.");
            }
        } while (keybrdInput != EXIT);
    }
}