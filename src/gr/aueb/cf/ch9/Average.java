package gr.aueb.cf.ch9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.rmi.ServerError;
import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        int count = 0;
        int sum = 0;
        int num = 0;
        double result = 0;
        String token;

        try (Scanner sc = new Scanner(new File("C:/Users/harko/IdeaProjects/CodingFactoryTestbed/src/gr/aueb/cf/ch9/out4.txt"));
             PrintStream ps = new PrintStream(new FileOutputStream("C:/Users/harko/IdeaProjects/CodingFactoryTestbed/src/gr/aueb/cf/ch9/out3.txt",true))) {
            while (sc.hasNext()) {
                token = sc.next();
                if (isInt(token)) {
                    num = Integer.parseInt(token);
                    ++count;
                    sum += num;
                }
            }

            result = sum / count;
            ps.println("The average is " + result);
        } catch (FileNotFoundException e) {
            System.err.println("File not Found");
            e.printStackTrace();
        }
    }

    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
