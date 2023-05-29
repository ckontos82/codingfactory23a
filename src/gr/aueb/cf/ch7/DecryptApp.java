package gr.aueb.cf.ch7;

import java.util.Scanner;

/**
 * This class provides a simple decryption application that decreases the ASCII
 * value of each character in a given string by 1. The decryption is performed
 * using a StringBuilder to store and manipulate the decrypted characters, and
 * the result is returned as a String.
 *
 * @author Charalampos Kontos
 */
public class DecryptApp {
    public static void main(String[] args) {
        String inputString;

        inputString = readUserInput("Please enter the string you want to be decrypted.");

        System.out.println("The decrypted string is: " + decrypt(inputString));
    }

    /**
     * Reads a string from the user with a given prompt and returns it.
     *
     * @param prompt the prompt to be displayed to the user
     * @return the input string from the user
     */
    public static String readUserInput(String prompt) {
        String input;
        Scanner in = new Scanner(System.in);

        System.out.println(prompt);
        input = in.nextLine();

        return input;
    }

    /**
     * Decrypts a string by decreasing the ASCII value of each character by 1
     * and returns the decrypted string. A StringBuilder is used internally to
     * store and manipulate the decrypted characters.
     *
     * @param inputString the string to be decrypted
     * @return the decrypted string
     */
    public static String decrypt(String inputString) {
        if (inputString == null) return "";

        StringBuilder decryptedStringBuilder = new StringBuilder(inputString.length());

        for (int i = 0; i < inputString.length(); i++) {
            decryptedStringBuilder.append((char) (inputString.charAt(i) - 1));
        }

        return decryptedStringBuilder.toString();
    }
}
