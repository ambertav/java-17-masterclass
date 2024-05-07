import java.util.Scanner;
import java.util.Arrays;

public class ArraySection {

    public static void main(String[] args) {

        int[] array = SortedArray.getIntegers(5);

        System.err.println("\n");
        System.err.println("Here is an array from the created integers: ");
        SortedArray.printArray(array);

        int[] sorted = SortedArray.sortIntegers(array);
        System.err.println("\n");

        System.err.println("Here is that same array, sorted in descending order: ");
        SortedArray.printArray(sorted);

    }

    // exercise 41
    /**
     * Contains static methods for working with arrays, including
     * obtaining integer values from user input, printing array elements,
     * and sorting array elements in descending order.
     */
    public class SortedArray {

        /**
         * Obtains integer values from user input and stores them in an array.
         * 
         * @param length The length of the array to be created.
         * @return An array containing the entered integer values.
         */
        public static int[] getIntegers(int length) {
            int[] array = new int[length];
            int counter = 0;

            Scanner scanner = new Scanner(System.in);
            System.out.printf("Enter %d integer values:\n", length);

            try {
                while (counter < length) {
                    String input = scanner.nextLine();
                    try {
                        int integer = Integer.parseInt(input);
                        array[counter] = integer;
                        counter++;
                    } catch (NumberFormatException error) {
                        System.out.println("Please enter a valid integer.");
                    }
                }
            } finally {
                scanner.close();
            }

            return array;
        }

        /**
         * Prints the indexes of the array and the corresponding elements.
         * 
         * @param array The array whose elements are to be printed.
         */
        public static void printArray(int[] array) {
            for (int i = 0; i < array.length; i++) {
                System.out.printf("Element %d contents %d%n", i, array[i]);
            }
        }

        /**
         * Sorts the elements of an array in descending order.
         * 
         * @param arr The array to be sorted.
         * @return The sorted array.
         */
        public static int[] sortIntegers(int[] arr) {

            // bubble sort implementation
            /*
             * boolean swap;
             * for (int i = arr.length - 1; i > 0; i--) {
             * swap = false;
             * for (int j = 0; j < i; j++) {
             * if (arr[j] < arr[j + 1]) {
             * int temp = arr[j];
             * arr[j] = arr[j + 1];
             * arr[j + 1] = temp;
             * swap = true;
             * }
             * }
             * if (!swap) break;
             * }
             * return arr;
             * 
             */

            // merge sort implementation
            return mergeSort(arr, 0, arr.length - 1);
        }

        /**
         * Merge two subarrays of the given array.
         * The first subarray is arr[left..middle]
         * The second subarray is arr[middle+1..right]
         *
         * @param arr    the array to be merged
         * @param left   the index of the leftmost element of the first subarray
         * @param middle the index of the middle element
         * @param right  the index of the rightmost element of the second subarray
         * @return the merged array
         */
        private static int[] merge(int[] arr, int left, int middle, int right) {
            int size1 = middle - left + 1;
            int size2 = right - middle;

            int[] leftSide = new int[size1];
            int[] rightSide = new int[size2];

            // Copy data to temporary arrays
            for (int i = 0; i < size1; ++i)
                leftSide[i] = arr[left + i];
            for (int j = 0; j < size2; ++j)
                rightSide[j] = arr[middle + 1 + j];

            int i = 0;
            int j = 0;

            int k = left;

            // Merge the temporary arrays back into arr[]
            while (i < size1 && j < size2) {
                if (leftSide[i] >= rightSide[j]) {
                    arr[k] = leftSide[i];
                    i++;
                } else {
                    arr[k] = rightSide[j];
                    j++;
                }
                k++;
            }

            // Copy remaining elements of leftSide[] if any
            while (i < size1) {
                arr[k] = leftSide[i];
                i++;
                k++;
            }

            // Copy remaining elements of rightSide[] if any
            while (j < size2) {
                arr[k] = rightSide[j];
                j++;
                k++;
            }

            return arr;
        }

        /**
         * Main function that sorts the given array using mergeSort algorithm.
         *
         * @param arr   the array to be sorted
         * @param left  the starting index of the array
         * @param right the ending index of the array
         * @return the sorted array
         */
        private static int[] mergeSort(int arr[], int left, int right) {
            if (left < right) {
                int middle = (left + right) / 2;

                // Sort first and second halves
                mergeSort(arr, left, middle);
                mergeSort(arr, middle + 1, right);

                // Merge the sorted halves
                return merge(arr, left, middle, right);
            }

            return arr;
        }
    }

    // exericse 42
    /**
     * A class to perform operations related to finding the minimum element in an
     * array.
     */
    public class MinimumElement {
        /**
         * Reads an integer from the console input.
         *
         * @return The integer entered by the user.
         */
        public static int readInteger() {
            Scanner scanner = new Scanner(System.in);
            System.out.printf("Enter an integer\n");

            int integer = scanner.nextInt();
            scanner.close();
            return integer;
        }

        /**
         * Reads integer elements from the console input.
         *
         * @param length The number of elements to be entered.
         * @return An array containing the entered integer values.
         */
        public static int[] readElements(int length) {
            int[] array = new int[length];
            int counter = 0;
            Scanner scanner = new Scanner(System.in);
            System.out.printf("Enter %d integer values:\n", length);

            try {
                while (counter < length) {
                    String input = scanner.nextLine();
                    try {
                        int integer = Integer.parseInt(input);
                        array[counter] = integer;
                        counter++;
                    } catch (NumberFormatException error) {
                        System.out.println("Please enter a valid integer.");
                    }
                }
            } finally {
                scanner.close();
            }
            return array;
        }

        /**
         * Finds the minimum value in an array.
         *
         * @param array The array to find the minimum value from.
         * @return The minimum value in the array.
         */
        public int findMin(int[] array) {
            int min = Integer.MAX_VALUE;
            for (int element : array) {
                if (element < min) {
                    min = element;
                }
            }
            return min;
        }
    }

    // exercise 43
    /**
     * Utility class to reverse an integer array.
     */
    public class ReverseArray {
        /**
         * Reverses the elements of the given integer array.
         *
         * @param array the integer array to be reversed
         * @return the reversed integer array
         */
        public static int[] reverse(int[] array) {
            int[] reversed = new int[array.length];
            int maxIndex = array.length - 1;
            for (int element : array) {
                reversed[maxIndex--] = element;
            }
            return reversed;
        }
    }
}
