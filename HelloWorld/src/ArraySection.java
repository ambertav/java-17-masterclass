import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

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

    // notes on nested arrays
    public class MestedArrays {
        public static void main(String[] args) {
            int[][] array = new int[4][4];
            System.out.println(Arrays.toString(array));
            for (int[] outer : array) {
                System.out.println(Arrays.toString(outer));
            }

            for (int i = 0; i < array.length; i++) {
                var innerArray = array[i];
                for (int j = 0; j < innerArray.length; j++) {
                    array[i][j] = (i * 10) + (j + 1);
                }
            }

            for (var outer : array) {
                for (var element : outer) {
                    System.out.println(element);
                }
            }

            System.out.println(Arrays.deepToString(array));

        }
    }

    // exercise 44
    /**
     * Represents a mobile phone with a list of contacts.
     */
    public class MobilePhone {
        private String myNumber;
        private ArrayList<Contact> myContacts;

        /**
         * Constructs a new MobilePhone object with the specified phone number.
         * Initializes an empty list of contacts.
         * 
         * @param myNumber The phone number associated with the mobile phone.
         */
        public MobilePhone(String myNumber) {
            this.myNumber = myNumber;
            this.myContacts = new ArrayList<>();
        }

        /**
         * Adds a new contact to the mobile phone's contact list.
         * 
         * @param newContact The contact to be added.
         * @return true if the contact was added successfully, false if the contact
         *         already exists.
         */
        public boolean addNewContact(Contact newContact) {
            int index = this.findContact(newContact);
            if (index == -1) {
                this.myContacts.add(newContact);
                return true;
            } else
                return false;
        }

        /**
         * Updates an existing contact in the mobile phone's contact list.
         * 
         * @param oldContact The existing contact to be updated.
         * @param newContact The new contact information.
         * @return true if the contact was updated successfully, false if the old
         *         contact does not exist.
         */
        public boolean updateContact(Contact oldContact, Contact newContact) {
            int indexOfContact = this.findContact(oldContact);
            if (indexOfContact == -1)
                return false;
            else {
                this.myContacts.set(indexOfContact, newContact);
                return true;
            }
        }

        /**
         * Removes a contact from the mobile phone's contact list.
         * 
         * @param contact The contact to be removed.
         * @return true if the contact was removed successfully, false if the contact
         *         does not exist.
         */
        public boolean removeContact(Contact contact) {
            return this.myContacts.remove(contact);
        }

        /**
         * Finds the index of a contact in the contact list.
         * 
         * @param contact The contact to search for.
         * @return The index of the contact in the contact list, or -1 if the contact is
         *         not found.
         */
        private int findContact(Contact contactToFind) {
            for (int i = 0; i < this.myContacts.size(); i++) {
                if (this.myContacts.get(i).getPhoneNumber() == contactToFind.getPhoneNumber())
                    return i;
            }

            return -1;
        }

        /**
         * Finds the index of a contact by name in the contact list.
         * 
         * @param name The name of the contact to search for.
         * @return The index of the contact in the contact list, or -1 if the contact is
         *         not found.
         */
        private int findContact(String name) {
            for (int i = 0; i < this.myContacts.size(); i++) {
                if (this.myContacts.get(i).getName() == name)
                    return i;
            }

            return -1;
        }

        /**
         * Finds a contact by name in the contact list.
         * 
         * @param name The name of the contact to search for.
         * @return The contact with the specified name, or null if the contact is not
         *         found.
         */
        public Contact queryContact(String name) {
            for (Contact contact : this.myContacts) {
                if (contact.getName() == name)
                    return contact;
            }
            return null;
        }

        /**
         * Prints the list of contacts.
         */
        public void printContacts() {
            System.out.println("Contact List:");
            for (int i = 0; i < this.myContacts.size(); i++) {
                Contact currentContact = this.myContacts.get(i);
                System.out.printf("%d. %s -> %s", i + 1, currentContact.getName(), currentContact.getPhoneNumber());
            }
        }
    }

    /**
     * Represents a contact with a name and a phone number.
     */
    public static class Contact {
        private String name;
        private String phoneNumber;

        /**
         * Constructs a new Contact object with the specified name and phone number.
         * 
         * @param name        The name of the contact.
         * @param phoneNumber The phone number of the contact.
         */
        public Contact(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        /**
         * Gets the name of the contact.
         * 
         * @return The name of the contact.
         */
        public String getName() {
            return this.name;
        }

        /**
         * Gets the phone number of the contact.
         * 
         * @return The phone number of the contact.
         */
        public String getPhoneNumber() {
            return this.phoneNumber;
        }

        /**
         * Creates a new Contact object with the specified name and phone number.
         * 
         * @param name        The name of the contact.
         * @param phoneNumber The phone number of the contact.
         * @return A new Contact object.
         */
        public static Contact createContact(String name, String phoneNumber) {
            return new Contact(name, phoneNumber);
        }
    }
}
