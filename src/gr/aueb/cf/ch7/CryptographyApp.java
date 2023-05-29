package gr.aueb.cf.ch7;

import java.util.Scanner;

/**
 * This class provides a simple encryption and decryption application that
 * increases and decreases the ASCII value of each character in a given string
 * by 1, respectively. The toCharArray method is used to convert the input string
 * to an array of characters for encryption, and an array of chars is used to
 * store and manipulate the encrypted characters. The decryption is performed
 * using a StringBuilder to store and manipulate the decrypted characters.
 *
 * @author Charalampos Kontos
 */
public class CryptographyApp {
    public static void main(String[] args) {
        String inputString;
        String encryptedString;
        String decryptedString;

        inputString = readUserInput("Please enter the string you want to be encrypted.");
        encryptedString = encrypt(inputString);
        decryptedString = decrypt(encryptedString);

        System.out.println("The encrypted string is: " + encryptedString);
        System.out.println("The decrypted string is: " + decryptedString);
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
        in.close();

        return input;
    }

    /**
     * Encrypts a string by increasing the ASCII value of each character by 1.
     *
     * @param inputString the string to be encrypted
     * @return the encrypted string
     */
    public static String encrypt(String inputString) {
        if (inputString == null) return "";

        char[] charArray = inputString.toCharArray();


        for (int i = 0; i < charArray.length; i++)
            ++charArray[i];

        return String.valueOf(charArray);
    }

    /**
     * Decrypts a string by decreasing the ASCII value of each character by 1
     * and returns the decrypted string. A StringBuilder is used internally to
     * store and manipulate the decrypted characters.
     *
     * @param encryptedString the string to be decrypted
     * @return the decrypted string
     */
    public static String decrypt(String encryptedString) {
        if (encryptedString == null) return "";

        StringBuilder decryptedStringBuilder = new StringBuilder(encryptedString.length());

        for (int i = 0; i < encryptedString.length(); i++)
            decryptedStringBuilder.append((char) (encryptedString.charAt(i) - 1));

        return decryptedStringBuilder.toString();
    }
}
