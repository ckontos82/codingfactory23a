package gr.aueb.cf.ch8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMismatch2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int inputNum;
        final int MAGIC_NUM = 12;

        while (true) {

                System.out.println("Plz enter a num");

                if (in.hasNextInt()) {
                    inputNum = in.nextInt();
                } else {
                    in.nextLine();
                    System.out.println("Please enter an int");
                    continue;
                }
                if (inputNum == MAGIC_NUM) {
                    System.out.println("Great");
                    break;
                }
        }
        System.out.println("Thanks for using the Magic App");
    }
}
