package gr.aueb.cf.projects;

/**
 * This class uses a recursive algorithm to find the maximum sum of a subarray within a one-dimensional array.
 *
 * @author Charalampos Kontos
 */
public class Project06 {
    static int globalMax = Integer.MIN_VALUE;
    public static void main(String[] args) {
        int[] initialArray = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        maxSumSubarray(initialArray, initialArray.length - 1);
        System.out.println("Maximum sum subarray (using recursion): " + globalMax);
        System.out.println("Maximum sum subarray (using iteration): " + maxSumSubarrayNoRecursion(initialArray));
    }

    /**
     * This method calculates the maximum sum of a contiguous subarray within the given array.
     * It does this by recursively calculating a local maximum sum at each index and updating the global maximum
     * sum if the local maximum is larger.
     *
     * 1st solution (using recursion).
     *
     * @param array The input array in which to find the maximum sum subarray.
     * @param index The current index for which to calculate the local maximum sum.
     * @return The local maximum sum for the current index.
     */
    public static int maxSumSubarray(int[] array, int index) {
        if (array == null || array.length < 1) return -1;

        int localMax;

        if (index == 0) {
            return array[0];
        }

        localMax = max(array[index], array[index] + maxSumSubarray(array, index - 1));
        globalMax = max(globalMax, localMax);
        return localMax;
    }

    /**
     * This method finds the maximum sum of a contiguous subarray within the given one-dimensional array.
     * It initializes two integer variables, maximum and localMax, to track the maximum subarray sum.
     * The method iterates over the array, at each step updating localMax to be the maximum of the
     * current element and the sum of the current element and the previous localMax. If the
     * localMax is greater than maximum, it updates maximum.
     * Finally, it returns maximum, which holds the maximum subarray sum.
     *
     * @param array The input array in which to find the maximum sum subarray.
     * @return The maximum sum of a subarray within the input array, or -1 if the array is null or empty.
     */
    public static int maxSumSubarrayNoRecursion(int[] array) {
        int maximum = Integer.MIN_VALUE;
        if (array == null || array.length < 1) return -1;

        int localMax = array[0];

        for (int i = 1; i < array.length; i++) {
            localMax = max(localMax + array[i], array[i]);
            maximum = max(localMax, maximum);
        }

        return maximum;
    }

    /**
     * Returns the greater of two integer values.
     *
     * @param a The first integer to compare.
     * @param b The second integer to compare.
     * @return The greater integer of a and b.
     */
    public static int max(int a, int b) {
        return a > b ? a : b;
    }
}
