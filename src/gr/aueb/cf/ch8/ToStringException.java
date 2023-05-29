package gr.aueb.cf.ch8;

import java.util.Scanner;

public class ToStringException {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num;
        String s;

        System.out.print("Enter an integer: ");
        s = in.next();

        try {
            num = toStr(s);
            System.out.println(num);
        } catch (NumberFormatException ex) {
            System.err.println("Not an integer");
        }
    }

    public static int toStr(String input) throws NumberFormatException {
        int number = -1;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            throw ex;
        }

        return number;
    }

}



