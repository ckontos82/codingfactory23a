package gr.aueb.cf.projects;

/**
 * The Project05 class is a Java program that finds the lowest and highest index
 * of a specific value in a sorted array.
 *
 * The methods in this class return an array of size 2. The first element is the lowest index of the key
 * and the second element is the highest index.
 *
 * If the key is not found in the array, the return array will be {-1, -1}.
 * If the array has less than 2 elements, or it is null, the return array will be {0, -1}.
 *
 * @author Charalampos Kontos
 */
public class Project05 {
    public static void main(String[] args) {
        int[] sampleArray = {-7, -3, -3, -3, 1, 4, 4, 4, 6, 7, 8, 8, 8, 8, 8, 9, 9, 9, 12, 12, 15};
        int[] results;

        results = getLowAndHighIndex(sampleArray, -3);
        System.out.println(results[0] + " " + results[1]);

        results = getLowAndHighIndexV2(sampleArray, 8);
        System.out.println(results[0] + " " + results[1]);

        results = getLowAndHighIndexV3(sampleArray, 4);
        System.out.println(results[0] + " " + results[1]);
    }

    /**
     * The getLowAndHighIndex method finds the lowest and highest index of a specific key in the provided array.
     *
     * 1st solution.
     *
     * @param array The sorted array in which to find the key.
     * @param key   The value to find in the array.
     * @return An array of size 2 where the first element is the lowest index of the key and
     * the second element is the highest index.
     */
    public static int[] getLowAndHighIndex(int[] array, int key) {
        int[] lowHighIndex = new int[2];

        if (array == null || array.length < 2) {
            lowHighIndex[0] = 0;
            lowHighIndex[1] = -1;
            return lowHighIndex;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                lowHighIndex[0] = i;
                break;
            } else {
                lowHighIndex[0] = -1;
                lowHighIndex[1] = -1;
            }
        }

        // If lowHighIndex[0] is -1, the key does not exist in the array, so there is
        // no need to execute the following "for" loop.
        if (lowHighIndex[0] > -1) {
            for (int j = array.length - 1; j >= lowHighIndex[0]; j--) {
                if (array[j] == key) {
                    lowHighIndex[1] = j;
                    break;
                }
            }
        }

        return lowHighIndex;
    }

    /**
     * The getLowAndHighIndex method finds the lowest and highest index of a specific key in the provided array.
     *
     * 2nd solution.
     *
     * @param array The sorted array in which to find the key.
     * @param key   The value to find in the array.
     * @return An array of size 2 where the first element is the lowest index of the key and
     * the second element is the highest index.
     */
    public static int[] getLowAndHighIndexV2(int[] array, int key) {
        int[] lowHighIndex = new int[2];
        if (array == null || array.length < 2) {
            lowHighIndex[0] = 0;
            lowHighIndex[1] = -1;
            return lowHighIndex;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                lowHighIndex[0] = i;
                for (int j = i; j < array.length; j++) {
                    if (array[j] == key) {
                        lowHighIndex[1] = j;
                    }
                }
                break;
            } else {
                lowHighIndex[0] = -1;
                lowHighIndex[1] = -1;
            }
        }

        return lowHighIndex;
    }

    /**
     * The getLowAndHighIndex method finds the lowest and highest index of a specific key in the provided array.
     *
     * 3rd solution.
     *
     * @param array The sorted array in which to find the key.
     * @param key   The value to find in the array.
     * @return An array of size 2 where the first element is the lowest index of the key and
     * the second element is the highest index.
     */
    public static int[] getLowAndHighIndexV3(int[] array, int key) {
        int[] lowHighIndex = new int[2];

        if (array == null || array.length < 2) {
            lowHighIndex[0] = 0;
            lowHighIndex[1] = -1;
            return lowHighIndex;
        }

        int[] indexArray = new int[array.length];
        int counter = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                indexArray[counter++] = i;
            }
        }

        lowHighIndex[0] = indexArray[0];
        if (counter > 0) {
            lowHighIndex[1] = indexArray[counter - 1];
        } else {
            lowHighIndex[0] = -1;
            lowHighIndex[1] = -1;
        }

        return lowHighIndex;
    }
}
