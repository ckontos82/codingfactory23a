package gr.aueb.cf.ch9;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class AutoFlushApp {
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            try (PrintStream ps = new PrintStream(new FileOutputStream("C:\\Users\\harko\\IdeaProjects\\CodingFactoryTestbed\\src\\gr\\aueb\\cf\\ch9\\flush.txt", true), true, StandardCharsets.UTF_8)) {
                ps.println("Καλησπέρα!");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
