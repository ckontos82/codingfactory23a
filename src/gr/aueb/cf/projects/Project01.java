package gr.aueb.cf.projects;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;


/**
 * The Project01 class is a Java program designed to read lotto numbers from a file,
 * perform certain calculations and checks, and output certain data to another file.
 *
 * @author Charalampos Kontos
 */
public class Project01 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("lotto6in.txt"));
             PrintStream ps = new PrintStream("lotto6out.txt", StandardCharsets.UTF_8)) {

            final int LOTTO_SIZE = 6;
            int[] inputNumbers = new int[49];
            int pivot = 0;
            int[] result = new int[6];
            int num;
            int window;

            while ((num = in.nextInt()) != -1 && pivot <= 48) {
                inputNumbers[pivot++] = num;
            }

            int[] numbers = Arrays.copyOfRange(inputNumbers, 0, pivot);
            Arrays.sort(numbers);

            window = pivot - LOTTO_SIZE;
            for (int i = 0; i <= window; i++) {
                for (int j = i + 1; j <= window + 1; j++) {
                    for (int k = j + 1; k <= window + 2; k++) {
                        for (int l = k + 1; l <= window + 3; l++) {
                            for (int m = l + 1; m <= window + 4; m++) {
                                for (int n = m + 1; n <= window + 5; n++) {
                                    result[0] = numbers[i];
                                    result[1] = numbers[j];
                                    result[2] = numbers[k];
                                    result[3] = numbers[l];
                                    result[4] = numbers[m];
                                    result[5] = numbers[n];
                                }

                                if(!isEvenGE(result, 4) && isOddGE(result, 4) && isContiguous(result, 2) &&
                                isSameEnding(result, 3) && isSameTen(result, 3))
                                    ps.printf("%d %d %d %d %d %d\n",
                                            result[0], result[1], result[2], result[3], result[4], result[5]);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * The isEvenGE method checks if the number of even numbers in an array is greater than a given threshold.
     *
     * @param arr The array of numbers to be checked.
     * @param threshold The minimum number of even numbers required.
     * @return True if the number of even numbers is greater than the threshold, false otherwise.
     */
    public static boolean isEvenGE(int[] arr, int threshold) {
        int even = 0;

        for (int num : arr) {
            if (num % 2 == 0) even++;
        }

        return even > threshold;
    }

    /**
     * The isOddGE method checks if the number of odd numbers in an array is greater than a given threshold.
     *
     * @param arr The array of numbers to be checked.
     * @param threshold The minimum number of odd numbers required.
     * @return True if the number of odd numbers is greater than the threshold, false otherwise.
     */
    public static boolean isOddGE(int[] arr, int threshold) {
        int odd = 0;

        for (int num : arr) {
            if (num % 2 == 1) odd++;
        }

        return odd > threshold;
    }

    /**
     * The isContiguous method checks if number of contiguous numbers in the array
     * is greater than a given threshold.
     *
     * @param arr The array of numbers to be checked.
     * @param threshold The maximum length of contiguous sequence allowed.
     * @return True if the maximum contiguous sequence is shorter than the threshold, false otherwise.
     */
    public static boolean isContiguous(int[] arr, int threshold) {
        int count = 0; // Counter for continuous sequence count

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] + 1 == arr[i + 1]) {
                count++;
            }
        }

        return count < threshold;
    }

    /**
     * The isSameEnding method checks if the array contains numbers that share the same last digit more
     * times than a given threshold.
     *
     * @param arr The array of numbers to be checked.
     * @param threshold The maximum allowed frequency of the same last digit.
     * @return True if no last digit appears more than the threshold, false otherwise.
     */
    public static boolean isSameEnding(int[] arr, int threshold) {
        int[] lastDigitCount = new int[10];
        int lastdigit;

        for (int number : arr) {
            lastdigit = number % 10;
            ++lastDigitCount[lastdigit];
        }

        for (int number : lastDigitCount) {
            if (number > threshold) {
                return false;
            }
        }

        return true;
    }

    /**
     * The isSameTen method checks if the array contains numbers that fall within the same tens group
     * (1-10, 11-20, 21-30, etc.) more times than a given threshold.
     *
     * @param arr The array of numbers to be checked.
     * @param threshold The maximum allowed frequency of numbers in the same tens group.
     * @return True if no tens group is represented more than the threshold, false otherwise.
     */
    public static boolean isSameTen(int[] arr, int threshold) {
        int[] tensCount = new int[5];
        int tens;

        for (int number : arr) {
            // Subtracting 1 before dividing by 10 ensures that numbers from 1-10 are counted in the same group
            // (index 0), numbers 11-20 are in the next group (index 1), and so on.
            tens = (number - 1) / 10;
            ++tensCount[tens];
        }

        for (int number : tensCount) {
            if (number > threshold) {
                return false;
            }
        }

        return true;
    }

}
