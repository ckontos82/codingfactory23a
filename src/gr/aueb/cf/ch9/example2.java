package gr.aueb.cf.ch9;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class example2 {
    public static void main(String[] args) {

        try (PrintWriter pw = new PrintWriter("C:/Users/harko/IdeaProjects/CodingFactoryTestbed/src/gr/aueb/cf/ch9/out4.txt")) {
            pw.println("Hello Coding Factory!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
