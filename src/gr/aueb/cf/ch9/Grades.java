package gr.aueb.cf.ch9;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * The Grades class is responsible for calculating the average grades of students
 * based on data read from a file. The calculated averages are then written to another file.
 * If the input file contains invalid data (grades outside the range of 0 to 10, or grades that
 * cannot be parsed as double), the class logs this information to a separate log file.
 *
 * @author Charalampos Kontos
 */
public class Grades {
    public static void main(String[] args) {
        File inFile = new File("grades.txt");
        File outFile = new File("primOut.txt");

        try {
            if(!outFile.exists()) {
                outFile.createNewFile();
            }
        } catch(IOException e) {
            System.err.println("Failed to create output file.");
            return;
        }

        try {
            readAndWriteAverage(inFile, outFile);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * This method is used to read the grade file, calculate the average, and write it to the output file.
     * @param inputFile This is the input file with student grades.
     * @param outputFile This is the output file to write averages.
     */
    public static void readAndWriteAverage(File inputFile, File outputFile) throws IOException {
        try(BufferedReader bfReader = new BufferedReader(new FileReader(inputFile, StandardCharsets.UTF_8));
            BufferedWriter bfWriter = new BufferedWriter(new FileWriter(outputFile, StandardCharsets.UTF_8, true))) {

            boolean validGrades;
            String line;
            String[] grades;
            double average;
            double sum;
            int counter;
            Logger logger = getLogger();

            while ((line = bfReader.readLine()) != null) {
                validGrades = true;
                grades = line.split(" +");

                //If the line is empty or does not contain grades, continue.
                if (grades.length <= 2) continue;

                sum = 0;
                counter = 0;
                for (int i = 2; i < grades.length; ++i) {
                    if (!isValidGrade(grades[i])) {
                        logger.info(String.format("Invalid data: %s %s, %s", grades[0], grades[1], grades[i]));
                        validGrades = false;
                        break;
                    }
                    sum += Double.parseDouble(grades[i]);
                    counter++;
                }

                if(validGrades) {
                    average = sum / counter;
                    bfWriter.write(String.format("%s %s: %.2f\n", grades[0], grades[1], average));
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to read from input file or write to output file");
            throw e;
        }
    }

    /**
     * This method is used to check if a grade is valid (between 0 and 10).
     * If the grade is not a valid number (can't be parsed as a double), it is also considered invalid.
     * @param grade This is the grade to check.
     * @return boolean This returns true if the grade is valid (i.e., a number between 0 and 10), false otherwise.
     */
    public static boolean isValidGrade(String grade) {
        try {
            return ((Double.parseDouble(grade) >= 0) && (Double.parseDouble(grade) <= 10));
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    /**
     * This method is used to set up the logger.
     * @return Logger This returns the logger.
     */
    public static Logger getLogger() {
        Logger logger = Logger.getLogger(Grades.class.getName());
        Handler fileHandler;

        try {
            fileHandler = new FileHandler("log.txt",true);
            fileHandler.setFormatter(new SimpleFormatter());
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        logger.addHandler(fileHandler);
        return logger;
    }
}
