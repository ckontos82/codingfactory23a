package gr.aueb.cf.ch7;

import java.util.Scanner;

public class StringInput {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s;

        System.out.print("Enter a string: ");
        s = in.next();

        System.out.print(s);

        s = in.nextLine();
        System.out.print(s);
    }
}
