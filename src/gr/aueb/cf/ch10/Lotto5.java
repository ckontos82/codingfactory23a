package gr.aueb.cf.ch10;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Lotto5 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("lotto5in.txt"));
             PrintStream ps = new PrintStream("lotto5out.txt", StandardCharsets.UTF_8)) {

            final int LOTTO_SIZE = 5;
            int[] inputNumbers = new int[49];
            int pivot = 0;
            int[] result = new int[5];
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
                                result[0] = numbers[i];
                                result[1] = numbers[j];
                                result[2] = numbers[k];
                                result[3] = numbers[l];
                                result[4] = numbers[m];

                                if(!isEvenGE(result, 3) && isOddGE(result, 3))
                                System.out.printf("%d %d %d %d %d\n", // me ps.printf gia na grapsei sto arxeio
                                        result[0], result[1], result[2], result[3], result[4]);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean isEvenGE(int[] arr, int threshold) {
        int even = 0;

        for (int num : arr) {
            if (num % 2 == 0) even++;
        }

        return even > threshold;
    }

    public static boolean isOddGE(int[] arr, int threshold) {
        int odd = 0;

        for (int num : arr) {
            if (num % 2 == 1) odd++;
        }

        return odd > threshold;
    }
}
