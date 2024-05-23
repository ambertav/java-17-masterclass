import java.util.Scanner;

import java.util.Arrays;
import java.util.ArrayList;

public class ArraySection {

    public static void main(String[] args) {

        // int[] array = SortedArray.getIntegers(5);

        // System.err.println("\n");
        // System.err.println("Here is an array from the created integers: ");
        // SortedArray.printArray(array);

        // int[] sorted = SortedArray.sortIntegers(array);
        // System.err.println("\n");

        // System.err.println("Here is that same array, sorted in descending order: ");
        // SortedArray.printArray(sorted);

        Bank bank = new Bank("National Bank");

        // Test 1: Add a new branch
        System.out.println(bank.addBranch("Downtown")); // Expected output: true

        // Test 2: Add a new customer to an existing branch
        System.out.println(bank.addCustomer("Downtown", "Alice", 100.50)); // Expected output: true

        // Test 3: Add a transaction for an existing customer
        System.out.println(bank.addCustomerTransaction("Downtown", "Alice", 50.75)); // Expected output: true

        // Test 4: List customers with transactions for a branch
        bank.listCustomers("Downtown", true); // Expected output: Customer details for branch: Downtown
                                              // Customer: Alice
                                              // Transactions:
                                              // $100.50 (deposit)
                                              // $50.75 (deposit)

        // Test 5: Attempt to add a new branch with an existing name
        System.out.println(bank.addBranch("Downtown")); // Expected output: false

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

    // exercise 45
    /**
     * The Bank class represents a bank with branches and customers.
     */

    public static class Bank {
        private String name;
        private ArrayList<Branch> branches;

        /**
         * Constructs a new Bank with the given name.
         *
         * @param name the name of the bank
         */
        public Bank(String name) {
            this.name = name;
            this.branches = new ArrayList<Branch>();
        }

        /**
         * Adds a new branch to the bank.
         *
         * @param nameOfBranch the name of the branch
         * @return true if the branch was added successfully, false if a branch with the
         *         given name already exists
         */
        public boolean addBranch(String nameOfBranch) {
            if (findBranch(nameOfBranch) == null) {
                this.branches.add(new Branch(nameOfBranch));
                return true;
            } else
                return false;
        }

        /**
         * Adds a new customer to a branch with an initial transaction.
         *
         * @param nameOfBranch   the name of the branch
         * @param nameOfCustomer the name of the customer
         * @param transaction    the initial transaction amount
         * @return true if the customer was added successfully, false if the branch or
         *         customer already exists
         */
        public boolean addCustomer(String nameOfBranch, String nameOfCustomer, double transaction) {
            Branch branch = findBranch(nameOfBranch);
            if (branch == null)
                return false;
            if (branch.findCustomer(nameOfCustomer) != null)
                return false;
            branch.newCustomer(nameOfCustomer, transaction);
            return true;
        }

        /**
         * Adds a transaction for an existing customer at a branch.
         *
         * @param nameOfBranch   the name of the branch
         * @param nameOfCustomer the name of the customer
         * @param transaction    the transaction amount
         * @return true if the transaction was added successfully, false if the branch
         *         or customer does not exist
         */
        public boolean addCustomerTransaction(String nameOfBranch, String nameOfCustomer, double transaction) {
            Branch branch = findBranch(nameOfBranch);
            if (branch == null)
                return false;
            else
                return branch.addCustomerTransaction(nameOfCustomer, transaction);
        }

        /**
         * Finds a branch by name.
         *
         * @param nameOfBranch the name of the branch
         * @return the Branch object if found, null otherwise
         */
        public Branch findBranch(String nameOfBranch) {
            for (Branch branch : this.branches) {
                if (branch.getName().equalsIgnoreCase(nameOfBranch))
                    return branch;
            }

            return null;
        }

        /**
         * Lists customers of a branch with optional transaction details.
         *
         * @param nameOfBranch      the name of the branch
         * @param printTransactions if true, prints transactions of each customer
         * @return true if the branch exists and customers are listed, false otherwise
         */
        public boolean listCustomers(String nameOfBranch, boolean printTransactions) {
            Branch branch = findBranch(nameOfBranch);
            if (branch == null)
                return false;

            System.out.printf("Customer details for branch: %s \n", branch.getName());
            for (Customer customer : branch.getCustomers()) {
                System.out.printf("Customer: %s \n", customer.getName());
                if (printTransactions) {
                    ArrayList<Double> transactions = customer.getTransactions();
                    System.out.println("Transactions: ");
                    for (Double transaction : transactions) {
                        System.out.printf("$%10.2f (%s)%n", transaction, transaction < 0 ? "withdrawal" : "deposit");
                    }
                }
            }

            return true;
        }

    }

    /**
     * The Branch class represents a branch of a bank with customers.
     */
    public static class Branch {
        private String name;
        private ArrayList<Customer> customers;

        /**
         * Constructs a new Branch with the given name.
         *
         * @param name the name of the branch
         */
        public Branch(String name) {
            this.name = name;
            this.customers = new ArrayList<Customer>();
        }

        /**
         * Gets the name of the branch.
         *
         * @return the name of the branch
         */
        public String getName() {
            return this.name;
        }

        /**
         * Gets the list of customers at the branch.
         *
         * @return the list of customers
         */
        public ArrayList<Customer> getCustomers() {
            return this.customers;
        }

        /**
         * Adds a new customer to the branch with an initial transaction.
         *
         * @param nameOfCustomer     the name of the customer
         * @param initialTransaction the initial transaction amount
         * @return true if the customer was added successfully, false if the customer
         *         already exists
         */
        public boolean newCustomer(String nameOfCustomer, double initialTransaction) {
            if (findCustomer(nameOfCustomer) == null) {
                Customer customer = new Customer(nameOfCustomer, initialTransaction);
                this.customers.add(customer);
                return true;
            } else
                return false;
        }

        /**
         * Adds a transaction for an existing customer.
         *
         * @param nameOfCustomer the name of the customer
         * @param transaction    the transaction amount
         * @return true if the transaction was added successfully, false if the customer
         *         does not exist
         */
        public boolean addCustomerTransaction(String nameOfCustomer, double transaction) {
            Customer customer = findCustomer(nameOfCustomer);
            if (customer == null)
                return false;
            else {
                customer.addTransaction(transaction);
                return true;
            }
        }

        /**
         * Finds a customer by name.
         *
         * @param nameOfCustomer the name of the customer
         * @return the Customer object if found, null otherwise
         */
        public Customer findCustomer(String nameOfCustomer) {
            for (Customer customer : this.customers) {
                if (customer.getName().equalsIgnoreCase(nameOfCustomer))
                    return customer;
            }

            return null;
        }
    }

    /**
     * The Customer class represents a customer of a bank branch with transactions.
     */
    public static class Customer {
        private String name;
        private ArrayList<Double> transactions;

        /**
         * Constructs a new Customer with the given name and initial transaction.
         *
         * @param name               the name of the customer
         * @param initialTransaction the initial transaction amount
         */
        public Customer(String name, double initialTransaction) {
            this.name = name;
            this.transactions = new ArrayList<Double>();
            this.transactions.add(initialTransaction);
        }

        /**
         * Gets the name of the customer.
         *
         * @return the name of the customer
         */
        public String getName() {
            return this.name;
        }

        /**
         * Gets the list of transactions of the customer.
         *
         * @return the list of transactions
         */
        public ArrayList<Double> getTransactions() {
            return this.transactions;
        }

        /**
         * Adds a transaction to the customer's transaction list.
         *
         * @param transaction the transaction amount
         */
        public void addTransaction(double transaction) {
            this.transactions.add(transaction);
        }
    }
}
