package gr.aueb.cf.ch8;

import java.util.Scanner;

public class ArithmException {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nominator;
        int denominator;
        int result = 0;

        while (true) {
            try {
                System.out.println("Please insert two ints");
                nominator = in.nextInt();
                denominator = in.nextInt();
                result = nominator / denominator;
                System.out.printf("%d / %d = %d", nominator, denominator, result);
                break;
            } catch (ArithmeticException ex) {
                System.err.println("Wrong denominator.");
                ex.printStackTrace();
            }
        }
    }
}
