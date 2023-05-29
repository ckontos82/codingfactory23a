package gr.aueb.cf.ch9;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class example3 {
    public static void main(String[] args) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("C:/Users/harko/IdeaProjects/CodingFactoryTestbed/src/gr/aueb/cf/ch9/out3.txt", true))) {
            pw.println("Hello Java and SQL!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
