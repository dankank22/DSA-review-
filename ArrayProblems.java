package problems;

/**
 * See the spec on the website for example behavior.
 *
 * REMEMBER THE FOLLOWING RESTRICTIONS:
 * - Do not add any additional imports
 * - Do not create new `int[]` objects for `toString` or `rotateRight`
 */
public class ArrayProblems {

    /**
     * Returns a `String` representation of the input array.
     * Always starts with '[' and ends with ']'; elements are separated by ',' and a space.
     */
    public static String toString(int[] array) {
        if (array.length == 0) {
            return "[]";
        }
        String result = "[";
        for (int i = 0; i < array.length; i++) {
            result = result + String.valueOf(array[i])+", ";
        }
        result = result.substring(0, result.length()-2);
        result = result + "]";
        return result;
    }

    /**
     * Returns a new array containing the input array's elements in reversed order.
     * Does not modify the input array.
     */
    public static int[] reverse(int[] array) {
        int[] newArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            newArray[array.length - 1 - i] = array[i];
        }
        return newArray;
    }

    /**
     * Rotates the values in the array to the right.
     */
    public static void rotateRight(int[] array) {
        int temp = 0;
        for (int i = 1; i < array.length; i++) {
            temp = array[0];
            array[0] = array[i];
            array[i] = temp;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }

    }
}
