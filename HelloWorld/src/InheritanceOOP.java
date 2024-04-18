public class InheritanceOOP {

    public void main() {

    }

    // exercise 30
    /**
     * The SimpleCalculator class represents a basic calculator
     * with four arithmetic operations:
     * addition, subtraction, multiplication, and division.
     */
    public class SimpleCalculator {
        private double firstNumber;
        private double secondNumber;

        /**
         * Gets the value of the first operand.
         * 
         * @return The value of the first operand.
         */
        public double getFirstNumber() {
            return firstNumber;
        }

        /**
         * Gets the value of the second operand.
         * 
         * @return The value of the second operand.
         */
        public double getSecondNumber() {
            return secondNumber;
        }

        /**
         * Sets the value of the first operand.
         * 
         * @param firstNumber The value to set for the first operand.
         */
        public void setFirstNumber(double firstNumber) {
            this.firstNumber = firstNumber;
        }

        /**
         * Sets the value of the second operand.
         * 
         * @param secondNumber The value to set for the second operand.
         */
        public void setSecondNumber(double secondNumber) {
            this.secondNumber = secondNumber;
        }

        /**
         * Calculates the sum of the two operands.
         * 
         * @return The result of adding the first and second operands.
         */
        public double getAdditionResult() {
            return firstNumber + secondNumber;
        }

        /**
         * Calculates the difference of the two operands.
         * 
         * @return The result of subtracting the second operand from the first operand.
         */
        public double getSubtractionResult() {
            return firstNumber - secondNumber;
        }

        /**
         * Calculates the product of the two operands.
         * 
         * @return The result of multiplying the first and second operands.
         */
        public double getMultiplicationResult() {
            return firstNumber * secondNumber;
        }

        /**
         * Calculates the quotient of the two operands.
         * 
         * @return The result of dividing the first operand by the second operand.
         *         If the second operand is zero, returns zero.
         */
        public double getDivisionResult() {
            if (secondNumber == 0)
                return 0;
            else
                return firstNumber / secondNumber;
        }
    }

    // exercise 31
    /**
     * The Person class represents a person with three attributes: first name, last
     * name, and age.
     */
    public class Person {
        private String firstName;
        private String lastName;
        private int age;

        /**
         * Gets the first name of the person.
         *
         * @return The first name of the person.
         */
        public String getFirstName() {
            return firstName;
        }

        /**
         * Gets the last name of the person.
         *
         * @return The last name of the person.
         */
        public String getLastName() {
            return lastName;
        }

        /**
         * Gets the age of the person.
         *
         * @return The age of the person.
         */
        public int getAge() {
            return age;
        }

        /**
         * Sets the first name of the person.
         *
         * @param firstName The first name to set for the person.
         */
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        /**
         * Sets the last name of the person.
         *
         * @param lastName The last name to set for the person.
         */
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        /**
         * Sets the age of the person.
         *
         * @param age The age to set for the person.
         *            If the age is less than 0 or greater than 100, age is set to 0.
         */
        public void setAge(int age) {
            if (age < 0 || age > 100)
                age = 0;
            this.age = age;
        }

        /**
         * Checks if the person is a teenager.
         *
         * @return True if the age of the person is between 13 and 19 (inclusive), false
         *         otherwise.
         */
        public boolean isTeen() {
            return (age > 12 && age < 20);
        }

        /**
         * Gets the full name of the person.
         *
         * @return The full name of the person.
         *         If both first name and last name are empty, returns an empty string.
         *         If only one of the first name or last name is empty, returns the
         *         non-empty one.
         *         Otherwise, returns the concatenation of the first name and last name
         *         separated by a space.
         */
        public String getFullName() {
            if (firstName.isEmpty() && lastName.isEmpty())
                return "";
            else if (lastName.isEmpty())
                return firstName;
            else if (firstName.isEmpty())
                return lastName;
            else
                return firstName + " " + lastName;
        }
    }
}
