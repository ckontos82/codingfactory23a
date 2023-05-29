package gr.aueb.cf.ch9;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintStreamGenericApp {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps = new PrintStream("C:\\Users\\harko\\IdeaProjects\\CodingFactoryTestbed\\src\\gr\\aueb\\cf\\ch9\\cf.txt");
        String s = "Hello Coding Factory!";

        printMessage(ps, s);
        printMessage(System.out, s);
    }

    public static void printMessage(PrintStream ps, String message) {
        ps.println(message);
    }
}
