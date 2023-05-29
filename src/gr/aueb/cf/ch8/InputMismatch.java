package gr.aueb.cf.ch8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMismatch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int inputNum;
        final int MAGIC_NUM = 12;

        while (true) {
            try {
                System.out.println("Plz enter a num");

                inputNum = in.nextInt();

                if (inputNum == MAGIC_NUM) {
                    System.out.println("Great");
                    break;
                }
            } catch (InputMismatchException e) {
                System.err.println("Not an integer");
                in.nextLine();
            }
        }
        System.out.println("Thanks for using the Magic App");
    }
}
