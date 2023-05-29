package gr.aueb.cf.ch9;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class WriterApp {
    public static void main(String[] args) {
        try (PrintStream ps = new PrintStream("C:\\Users\\harko\\IdeaProjects\\CodingFactoryTestbed\\src\\gr\\aueb\\cf\\ch9\\cfout.txt", StandardCharsets.UTF_8);
             PrintWriter pw = new PrintWriter("C:\\Users\\harko\\IdeaProjects\\CodingFactoryTestbed\\src\\gr\\aueb\\cf\\ch9\\cf2.txt")) {
            ps.println("Hello CF from printStream! Γειά σας!");
            pw.println("Hello CF from Print Writer!");
            pw.flush();
        } catch (IOException e) {
            System.out.println("File path not found");
            e.printStackTrace();
        }
    }
}
