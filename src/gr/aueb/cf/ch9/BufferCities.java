package gr.aueb.cf.ch9;

import java.io.*;

public class BufferCities {
    public static void main(String[] args) {
        String line;
        String[] cities;
        File dir = new File("C:/Users/harko/IdeaProjects/CodingFactoryTestbed/src/gr/aueb/cf/ch9/");

        if (!dir.exists())
            if (!dir.mkdir()) {
                System.err.println("Directοry cannot be created.");
                System.exit(1);
            }

        try (BufferedReader bf = new BufferedReader(new FileReader("C:/Users/harko/IdeaProjects/CodingFactoryTestbed/src/gr/aueb/cf/ch9/out3.txt"))) {
            File grFile, usaFile, deFile;
            while ((line = bf.readLine()) != null) {
                cities = line.split(" +");
                switch (cities[0]) {
                    case "Greece":
                        grFile = new File(dir + "/" + "gr.txt");
                        PrintStream gr = new PrintStream(grFile);
                        print(gr, "GR Cities");
                        print(gr, cities);
                        break;
                    case "USA":
                        usaFile = new File(dir + "/" + "usa.txt");
                        PrintStream us = new PrintStream(usaFile);
                        print(us, "US Cities");
                        print(us, cities);
                        break;
                    case "Germany":
                        deFile = new File(dir + "/" + "de.txt");
                        PrintStream de = new PrintStream(deFile);
                        print(de, "DE Cities");
                        print(de, cities);
                        break;
                    default:
                        System.out.println("Error");
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
            e.printStackTrace();
        } catch (IOException ex) {
            System.err.println("IO error");
            ex.printStackTrace();
        }
    }

    public static void print (PrintStream ps, String[] tokens) {
        for (int i = 1; i < tokens.length; i++)
            ps.println(tokens[i]);
    }

    public static void print (PrintStream ps, String message) {
        ps.println(message+"\n");
    }
}
