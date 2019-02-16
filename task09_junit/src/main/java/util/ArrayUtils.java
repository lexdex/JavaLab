package util;

/**
 * Utility array class from third task
 */
public class ArrayUtils {

    private static int[] removeValueFromArray(int[] arr, int value) {
        int[] result = arr;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                result = removeElementFromArrayByIndex(arr, i);
            }
        }

        return result;
    }

    public static int[] removeElementFromArrayByIndex(int[] src, int element) {
        int[] dest = new int[src.length - 1];

        System.arraycopy(src, 0, dest, 0, element);
        System.arraycopy(src, element + 1, dest, element, src.length - element - 1);

        return dest;
    }

    private static int countValuesInArray(int[] arr, int value) {
        int count = 0;

        for (int i : arr) {
            if (i == value) {
                count++;
            }
        }
        return count;
    }

    public static int[] addToArray(int[] arr, int value) {
        int[] result = arr;

        result = updateArray(result, result.length + 1);
        result[result.length - 1] = value;

        return result;
    }

    /**
     * Creates array based on given array with new size.
     */
    public static int[] updateArray(int[] src, int size) {
        int[] dest = new int[size];

        if (size > src.length) {
            System.arraycopy(src, 0, dest, 0, src.length);
        } else {
            System.arraycopy(src, 0, dest, 0, size);
        }

        return dest;
    }


    public static boolean contains(final int[] array, final int value) {
        boolean result = false;

        for (int i : array) {
            if (i == value) {
                result = true;
                break;
            }
        }

        return result;
    }
}
