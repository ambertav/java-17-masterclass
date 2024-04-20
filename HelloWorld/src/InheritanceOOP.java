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

    // exercise 32
    /**
     * The Wall class represents a wall with width and height dimensions.
     */
    public class Wall {
        private double width;
        private double height;

        /**
         * Constructs a wall with default width and height (both set to 0).
         */
        public Wall() {
            this(0, 0);
        }

        /**
         * Constructs a wall with specified width and height.
         * If width or height is negative, it is set to 0.
         * 
         * @param width  The width of the wall.
         * @param height The height of the wall.
         */
        public Wall(double width, double height) {
            if (width < 0)
                width = 0;
            if (height < 0)
                height = 0;

            this.width = width;
            this.height = height;
        }

        /**
         * Gets the width of the wall.
         * 
         * @return The width of the wall.
         */
        public double getWidth() {
            return width;
        }

        /**
         * Gets the height of the wall.
         * 
         * @return The height of the wall.
         */
        public double getHeight() {
            return height;
        }

        /**
         * Sets the width of the wall.
         * If width is negative, it is set to 0.
         * 
         * @param width The width to set.
         */
        public void setWidth(double width) {
            if (width < 0)
                width = 0;
            this.width = width;
        }

        /**
         * Sets the height of the wall.
         * If height is negative, it is set to 0.
         * 
         * @param height The height to set.
         */
        public void setHeight(double height) {
            if (height < 0)
                height = 0;
            this.height = height;
        }

        /**
         * Calculates and returns the area of the wall.
         * 
         * @return The area of the wall.
         */
        public double getArea() {
            return width * height;
        }
    }

    // exercise 33
    /**
     * The Point class represents a point in a 2-dimensional space with x and y
     * coordinates.
     */
    public class Point {
        private int x;
        private int y;

        /**
         * Constructs a point at the origin (0, 0).
         */
        public Point() {
            this(0, 0);
        }

        /**
         * Constructs a point with specified x and y coordinates.
         * 
         * @param x The x-coordinate of the point.
         * @param y The y-coordinate of the point.
         */
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        /**
         * Gets the x-coordinate of the point.
         * 
         * @return The x-coordinate of the point.
         */
        public int getX() {
            return x;
        }

        /**
         * Gets the y-coordinate of the point.
         * 
         * @return The y-coordinate of the point.
         */
        public int getY() {
            return y;
        }

        /**
         * Sets the x-coordinate of the point.
         * 
         * @param x The x-coordinate to set.
         */
        public void setX(int x) {
            this.x = x;
        }

        /**
         * Sets the y-coordinate of the point.
         * 
         * @param y The y-coordinate to set.
         */
        public void setY(int y) {
            this.y = y;
        }

        /**
         * Calculates the distance between this point and the origin (0, 0).
         * 
         * @return The distance between this point and the origin.
         */
        public double distance() {
            return Math.sqrt(((this.x - 0) * (this.x - 0)) + ((this.y - 0) * (this.y - 0)));
        }

        /**
         * Calculates the distance between this point and another point.
         * 
         * @param point The other point.
         * @return The distance between this point and the other point.
         */
        public double distance(Point point) {
            return Math.sqrt(((this.x - point.getX()) * (this.x - point.getX()))
                    + ((this.y - point.getY()) * (this.y - point.getY())));
        }

        /**
         * Calculates the distance between this point and a specified point (x, y).
         * 
         * @param x The x-coordinate of the specified point.
         * @param y The y-coordinate of the specified point.
         * @return The distance between this point and the specified point.
         */
        public double distance(int x, int y) {
            return Math.sqrt(((this.x - x) * (this.x - x)) + ((this.y - y) * (this.y - y)));
        }
    }
}
