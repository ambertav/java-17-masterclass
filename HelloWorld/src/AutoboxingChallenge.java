import java.util.ArrayList;

/**
 * The AutoboxingChallenge class serves as the entry point to demonstrate the
 * Bank and Customer classes.
 */
public class AutoboxingChallenge {
    public static void main(String[] args) {
        Bank bank = new Bank("Sample Bank");
        bank.addCustomer("John Doe", 100.00);
        bank.addTransaction("John Doe", 50.00);
        bank.addTransaction("John Doe", -30.00);
        bank.printStatement("John Doe");
    }

    /**
     * The Bank class represents a bank with customers and their transactions.
     */
    public static class Bank {
        private String name;
        private ArrayList<Customer> customers;

        /**
         * Constructs a new Bank with the specified name.
         *
         * @param name the name of the bank
         */
        public Bank(String name) {
            this.name = name;
            this.customers = new ArrayList<Customer>(5000);
        }

        /**
         * Adds a new customer to the bank if a customer with the same name does not
         * already exist.
         *
         * @param customerName     the name of the customer
         * @param firstTransaction the initial transaction amount
         * @return true if the customer was added successfully, false otherwise
         */
        public boolean addCustomer(String customerName, double firstTransaction) {
            if (findCustomer(name) == null) {
                Customer customer = new Customer(customerName, firstTransaction);
                this.customers.add(customer);
                return true;
            } else
                return false;
        }

        /**
         * Finds a customer by name.
         *
         * @param name the name of the customer to find
         * @return the Customer object if found, null otherwise
         */
        public Customer findCustomer(String name) {
            for (Customer customer : this.customers) {
                if (customer.getName().equalsIgnoreCase(name)) {
                    return customer;
                }
            }

            return null;
        }

        /**
         * Adds a transaction for a specified customer.
         *
         * @param name   the name of the customer
         * @param amount the amount of the transaction
         * @return true if the transaction was added successfully, false otherwise
         */
        public boolean addTransaction(String name, double amount) {
            Customer customer = findCustomer(name);
            if (customer != null) {
                customer.getTransactions().add(amount);
                return true;
            } else
                return false;
        }

        /**
         * Prints the statement of a specified customer.
         *
         * @param name the name of the customer
         */
        public void printStatement(String name) {
            Customer customer = findCustomer(name);
            if (customer == null)
                return;

            System.out.println("-".repeat(10));
            System.out.printf("Customer Name: %s \n", customer.getName().toUpperCase());
            System.out.println("Transactions: ");
            for (double d : customer.getTransactions()) {
                System.out.printf("$%10.2f (%s)%n", d, d < 0 ? "withdrawal" : "deposit");
            }
        }

        @Override
        public String toString() {
            return "Bank{" + "name= '" + name + '\'' +
                    ", customers=" + customers +
                    '}';
        }
    }

    /**
     * The Customer class represents a customer with a name and a list of
     * transactions.
     */
    public static class Customer {
        private String name;
        private ArrayList<Double> transactions;

        /**
         * Constructs a new Customer with the specified name.
         *
         * @param name the name of the customer
         */
        public Customer(String name) {
            this.name = name;
            this.transactions = new ArrayList<Double>(500);
        }

        /**
         * Constructs a new Customer with the specified name and an initial transaction.
         *
         * @param name             the name of the customer
         * @param firstTransaction the initial transaction amount
         */
        public Customer(String name, double firstTransaction) {
            this.name = name;
            this.transactions = new ArrayList<Double>(500);
            this.transactions.add(firstTransaction);
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
         * Gets the list of transactions for the customer.
         *
         * @return the list of transactions
         */
        public ArrayList<Double> getTransactions() {
            return this.transactions;
        }
    }
}