/**
 * This class analyzes a text file to determine the frequency of each character that appears in the file.
 * It creates a two-dimensional array where the first dimension represents each unique character,
 * and the second dimension contains two elements: the character itself and its frequency.
 * The results are then sorted by character code and frequency, and displayed.
 *
 * @author Charalampos Kontos
 */
package gr.aueb.cf.projects;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Project03 {

    public static void main(String[] args) {
        try {
            char[][] charArray = populateArrayFromFile("sample.txt");
            char[][] sortedByCharCode = sortArrayByCharCode(copyArray(charArray));
            char[][] sortedByFrequency = sortArrayByFrequency(copyArray(charArray));
            printArray(sortedByCharCode, "Sorted by Char Code:");
            printArray(sortedByFrequency, "\nSorted by Frequency:");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method reads a UTF-8 text file and populates a 2D character array.
     * The first dimension of the array represents each unique character found in the file,
     * and the second dimension contains two elements: the character itself and its frequency.
     *
     * @param filename The name of the text file to read.
     * @return The populated character array.
     * @throws IOException if there is a problem reading the file.
     */
    public static char[][] populateArrayFromFile(String filename) throws IOException {
        char[][] charArray = new char[256][2];
        int pivot = 0;

        try (InputStreamReader fr = new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8)) {
            int character;
            while ((character = fr.read()) != -1) {
                boolean found = false;
                for (int i = 0; i < pivot; i++) {
                    if (charArray[i][0] == character) {
                        charArray[i][1]++;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    charArray[pivot][0] = (char) character;
                    charArray[pivot][1] = 1;
                    pivot++;
                }
            }
        }
        return charArray;
    }

    /**
     * This method sorts a 2D character array by character code using selection sort.
     *
     * @param array The character array to sort.
     * @return The sorted character array.
     */
    public static char[][] sortArrayByCharCode(char[][] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j][0] < array[index][0]) {
                    index = j;
                }
            }
            char[] smallerCharCode = {array[index][0], array[index][1]};
            array[index] = array[i];
            array[i] = smallerCharCode;
        }
        return array;
    }

    /**
     * This method sorts a 2D character array by frequency using selection sort.
     * If two elements have the same frequency, they are further sorted by character code.
     *
     * @param array The character array to sort.
     * @return The sorted character array.
     */
    public static char[][] sortArrayByFrequency(char[][] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                // If frequencies are equal, compare character codes
                if (array[j][1] < array[index][1]
                        || (array[j][1] == array[index][1] && array[j][0] < array[index][0])) {
                    index = j;
                }
            }
            char[] smallerFrequency = {array[index][0], array[index][1]};
            array[index] = array[i];
            array[i] = smallerFrequency;
        }
        return array;
    }

    /**
     * This method prints a 2D character array with a header.
     * Each element of the array represents a character and its frequency.
     *
     * @param array  The character array to print.
     * @param header The header to print before the array.
     */
    public static void printArray(char[][] array, String header) {
        System.out.println(header);
        for (int i = 0; i < array.length; i++) {
            if ((int)(array[i][1]) > 0) {
                if ((int)(array[i][0]) == 10) {
                    System.out.printf("Character \"Line feed\" (Code %d): Frequency: %d\n", (int) array[i][0], (int) array[i][1]);
                } else if ((int)(array[i][0]) == 13) {
                    System.out.printf("Character \"Carriage return\" (Code %d): Frequency: %d\n", (int) array[i][0], (int) array[i][1]);
                } else if((int)(array[i][0]) == 32) {
                    System.out.printf("Character \"Space\" (Code %d): Frequency: %d\n", (int) array[i][0], (int) array[i][1]);
                } else {
                    System.out.printf("Character %c (Code %d): Frequency: %d\n", array[i][0], (int) array[i][0], (int) array[i][1]);
                }
            }
        }
    }

    /**
     * This method copies a 2D character array.
     *
     * @param original The character array to copy.
     * @return The copy of the character array.
     */
    public static char[][] copyArray(char[][] original) {
        char[][] copy = new char[original.length][2];
        for (int i = 0; i < original.length; i++) {
            copy[i][0] = original[i][0];
            copy[i][1] = original[i][1];
        }
        return copy;
    }
}
