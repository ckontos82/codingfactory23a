package gr.aueb.cf.ch9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NioCopyApp {
    public static void main(String[] args) {
        byte[] buffer;
        Path sourcePath = Paths.get("C:\\Users\\harko\\IdeaProjects\\CodingFactoryTestbed\\src\\gr\\aueb\\cf\\ch9\\me.jpg");
        Path destPath = Paths.get("C:\\Users\\harko\\IdeaProjects\\CodingFactoryTestbed\\src\\gr\\aueb\\cf\\ch9\\me_copy_2.jpg");

        try {
            buffer = Files.readAllBytes(sourcePath);
            Files.write(destPath, buffer);
        } catch (IOException e) {

        }
    }
}
