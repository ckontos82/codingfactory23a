package gr.aueb.cf.ch9;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class example1 {
    public static void main(String[] args) {
        try (PrintStream ps = new PrintStream("C:/Users/harko/IdeaProjects/CodingFactoryTestbed/src/gr/aueb/cf/ch9/out1.txt")) {
            ps.println("Hello Intermediate programming again!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
