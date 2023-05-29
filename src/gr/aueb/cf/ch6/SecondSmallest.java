package gr.aueb.cf.ch6;

/**
 * This class demonstrates finding the second smallest
 * element in an integer array.
 * The array is initialized with random integer values
 * between the defined LOWER_BOUND and UPPER_BOUND.
 *
 * The following constants are used in the program:
 * LOWER_BOUND: The lower bound (inclusive) for the random
 * integers in the array.
 * UPPER_BOUND: The upper bound (inclusive) for the random
 * integers in the array.
 * INVALID_INDEX: A constant representing an invalid index
 * in the array (-1).
 *
 * @author Charalampos Kontos
 */
public class SecondSmallest {
    static final int UPPER_BOUND = 100;
    static final int LOWER_BOUND = -100;
    static final int INVALID_INDEX = - 1;

    public static void main(String[] args) {
        final int LENGTH = 20;
        int[] array = new int[LENGTH];
        int index;

        arrayInitialize(array);
        printArray(array);
        index = findSecondSmallestElementIndex(array);
        printElement(array, index);
    }

    /**
     * Initializes the given integer array with random values
     * between LOWER_BOUND and UPPER_BOUND.
     *
     * @param array the integer array to initialize
     */
    public static void arrayInitialize(int[] array) {
        if (array == null) return;

        for (int i = 0; i < array.length; i++)
            array[i] = (int) (Math.random() * (UPPER_BOUND - LOWER_BOUND + 1)) + LOWER_BOUND;
    }

    /**
     * Prints the elements of the given integer array.
     *
     * @param array the integer array to print
     */
    public static void printArray(int[] array) {
        if (array == null) return;

        System.out.print("Array: ");
        for (int item : array)
            System.out.print(item + " ");
        System.out.println();
    }

    /**
     * Finds and returns the index of the second smallest element
     * in the given integer array.
     *
     * @param array the integer array to search
     * @return the index of the second smallest element in the array
     *         or -1 if the array is null or has fewer than two
     *         elements
     */
    public static int findSecondSmallestElementIndex(int[] array) {
        if (array == null || array.length < 2) {
            System.out.println("Array should have at least two elements.");
            return -1;
        }

        int smallestIndex;
        int secondSmallestIndex;

        // Initialize the smallestIndex and secondSmallestIndex based on
        // the first two elements
        if (array[0] < array[1]) {
            smallestIndex = 0;
            secondSmallestIndex = 1;
        } else {
            smallestIndex = 1;
            secondSmallestIndex = 0;
        }

        // Iterate through the rest of the array, starting from the 3rd element (index 2)
        for (int i = 2; i < array.length; i++) {
            // If the current element is smaller than the smallest element found so far,
            // update both the smallest and second smallest indices
            if (array[i] < array[smallestIndex]) {
                secondSmallestIndex = smallestIndex;
                smallestIndex = i;
            }
            // If the current element is not smaller than the smallest element but is
            // smaller than the second smallest element, update the second smallest index
            else if (array[i] < array[secondSmallestIndex]) {
                secondSmallestIndex = i;
            }
        }

        return secondSmallestIndex;
    }

    /**
     * Prints the value of the specified element in the given integer array.
     * If the index is INVALID_INDEX, prints an error message.
     *
     * @param array the integer array containing the element to print
     * @param index the index of the element to print
     */
    public static void printElement(int[] array, int index) {
        if (array == null) return;

        if (index != INVALID_INDEX) {
            System.out.println("The second smallest element of the array is: " + array[index]);
        } else {
            System.out.println("Invalid array. The array is either null or has fewer than two elements.");
        }
    }
}