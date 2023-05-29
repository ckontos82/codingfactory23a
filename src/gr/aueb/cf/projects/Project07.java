package gr.aueb.cf.projects;

import java.util.Arrays;

/**
 * This program demonstrates the difference between shallow copy and deep copy in Java.
 *
 * @author Charalampos Kontos
 */
public class Project07 {
    public static void main(String[] args) {
        int[][] initialArray = new int[5][5];
        int[][] shallowCopy;
        int[][] deepCopy;

        initArray(initialArray);
        shallowCopy = shallowCopy(initialArray);
        deepCopy = deepCopy(initialArray);

        System.out.println("Initial array: ");
        printArray(initialArray);
        System.out.println();

        System.out.println("Filling initial array with zeros.");
        fillWithZeros(initialArray);
        System.out.println("Initial array:");
        printArray(initialArray);
        System.out.println();
        System.out.println("Shallow copied array: ");
        printArray(shallowCopy);
        System.out.println();
        System.out.println("Deep copied array: ");
        printArray(deepCopy);
    }

    /**
     * Returns a shallow copy of the provided 2D array.
     * @param array the 2D array to be copied
     * @return shallow copy of the array
     */
    public static int[][] shallowCopy(int[][] array) {
        return Arrays.copyOf(array, array.length);
    }

    /**
     * Returns a deep copy of the provided 2D array.
     * @param array the 2D array to be copied
     * @return deep copy of the array
     */
    public static int[][] deepCopy(int[][] array) {
        int[][] copy = new int[array.length][array[0].length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                copy[i][j] = array[i][j];
            }
        }

        return copy;
    }

    /**
     * Initializes the given array with random numbers between -50 and 50.
     * @param array the 2D array to be initialized
     */
    public static void initArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = (int)(Math.random() * ((50 - (-50)) + 1));
            }
        }
    }

    /**
     * Prints the given array to the console.
     * @param array the 2D array to be printed
     */
    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Fills the given array with zeros.
     * @param array the 2D array to be filled
     */
    public static void fillWithZeros(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = 0;
            }
        }
    }
}
