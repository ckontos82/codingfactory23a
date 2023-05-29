package gr.aueb.cf.ch9;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyRawDataApp {
    public static void main(String[] args) {

        int b = 0;
        int count = 0;
        byte[] buffer = new byte[4096];
        long tic, toc;
        double elapsed;

        try (FileInputStream in = new FileInputStream("C:\\Users\\harko\\IdeaProjects\\CodingFactoryTestbed\\src\\gr\\aueb\\cf\\ch9\\me.jpg");
             FileOutputStream out = new FileOutputStream("C:\\Users\\harko\\IdeaProjects\\CodingFactoryTestbed\\src\\gr\\aueb\\cf\\ch9\\me_copy.jpg")) {

            tic = System.currentTimeMillis();
            while ((b = in.read(buffer)) != -1) {
                out.write(buffer, 0, b);
                count+= b;
            }
            toc = System.currentTimeMillis();
            elapsed = (toc - tic);
            System.out.println(elapsed + " ms");
            System.out.printf("%d Bytes\n", count);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
