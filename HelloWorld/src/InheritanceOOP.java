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

    // exericse 34
    /**
     * Represents a floor with a given width and length.
     */
    public class Floor {
        private double width;
        private double length;

        /**
         * Constructs a floor with the specified width and length.
         * If width or length is negative, it sets them to 0.
         * 
         * @param width  the width of the floor
         * @param length the length of the floor
         */
        public Floor(double width, double length) {
            if (width < 0)
                width = 0;
            if (length < 0)
                length = 0;

            this.width = width;
            this.length = length;

        }

        /**
         * Calculates and returns the area of the floor.
         * 
         * @return the area of the floor
         */
        public double getArea() {
            return this.width * this.length;
        }
    }

    /**
     * Represents a carpet with a given cost per square unit.
     */
    public class Carpet {
        private double cost;

        /**
         * Constructs a carpet with the specified cost per square unit.
         * If the cost is negative, it sets it to 0.
         * 
         * @param cost the cost per square unit of the carpet
         */
        public Carpet(double cost) {
            if (cost < 0)
                cost = 0;
            this.cost = cost;
        }

        /**
         * Returns the cost per square unit of the carpet.
         * 
         * @return the cost per square unit of the carpet
         */
        public double getCost() {
            return this.cost;
        }
    }

    /**
     * Represents a calculator for calculating the total cost of carpeting a floor.
     */
    public class Calculator {
        private Floor floor;
        private Carpet carpet;

        /**
         * Constructs a calculator with the specified floor and carpet.
         * 
         * @param floor  the floor to be carpeted
         * @param carpet the carpet to be used
         */
        public Calculator(Floor floor, Carpet carpet) {
            this.floor = floor;
            this.carpet = carpet;
        }

        /**
         * Calculates and returns the total cost of carpeting the floor.
         * 
         * @return the total cost of carpeting the floor
         */
        public double getTotalCost() {
            return floor.getArea() * carpet.getCost();
        }
    }

    // exercise 35
    /**
     * Represents a complex number with real and imaginary parts.
     */
    public class ComplexNumber {
        private double real;
        private double imaginary;

        /**
         * Constructs a complex number with the specified real and imaginary parts.
         * 
         * @param real      the real part of the complex number
         * @param imaginary the imaginary part of the complex number
         */
        public ComplexNumber(double real, double imaginary) {
            this.real = real;
            this.imaginary = imaginary;
        }

        /**
         * Returns the real part of the complex number.
         * 
         * @return the real part of the complex number
         */
        public double getReal() {
            return this.real;
        }

        /**
         * Returns the imaginary part of the complex number.
         * 
         * @return the imaginary part of the complex number
         */
        public double getImaginary() {
            return this.imaginary;
        }

        /**
         * Adds the specified real and imaginary parts to this complex number.
         * 
         * @param real      the real part to be added
         * @param imaginary the imaginary part to be added
         */
        public void add(double real, double imaginary) {
            this.real += real;
            this.imaginary += imaginary;
        }

        /**
         * Adds the specified complex number to this complex number.
         * 
         * @param second the complex number to be added
         */
        public void add(ComplexNumber second) {
            add(second.real, second.imaginary);
        }

        /**
         * Subtracts the specified real and imaginary parts from this complex number.
         * 
         * @param real      the real part to be subtracted
         * @param imaginary the imaginary part to be subtracted
         */
        public void subtract(double real, double imaginary) {
            this.real -= real;
            this.imaginary -= imaginary;
        }

        /**
         * Subtracts the specified complex number from this complex number.
         * 
         * @param second the complex number to be subtracted
         */
        public void subtract(ComplexNumber second) {
            subtract(second.real, second.imaginary);
        }
    }

    // exercise 36
    /**
     * Represents a circle with a given radius.
     */
    public class Circle {
        private double radius;

        /**
         * Constructs a circle with the specified radius.
         * 
         * @param radius the radius of the circle
         */
        public Circle(double radius) {
            if (radius < 0)
                radius = 0;
            this.radius = radius;
        }

        /**
         * Returns the radius of the circle.
         * 
         * @return the radius of the circle
         */
        public double getRadius() {
            return this.radius;
        }

        /**
         * Calculates and returns the area of the circle.
         * 
         * @return the area of the circle
         */
        public double getArea() {
            return radius * radius * Math.PI;
        }
    }

    /**
     * Represents a cylinder, a subclass of Circle, with a given height.
     */
    public class Cylinder extends Circle {
        private double height;

        /**
         * Constructs a cylinder with the specified radius and height.
         * 
         * @param radius the radius of the base circle of the cylinder
         * @param height the height of the cylinder
         */
        public Cylinder(double radius, double height) {
            super(radius);

            if (height < 0)
                height = 0;
            this.height = height;
        }

        /**
         * Returns the height of the cylinder.
         * 
         * @return the height of the cylinder
         */
        public double getHeight() {
            return this.height;
        }

        /**
         * Calculates and returns the volume of the cylinder.
         * 
         * @return the volume of the cylinder
         */
        public double getVolume() {
            return super.getArea() * this.height;
        }
    }

    // exercise 37
    /**
     * Represents a rectangle with a given width and length.
     */
    public class Rectangle {
        private double width;
        private double length;

        /**
         * Constructs a rectangle with the specified width and length.
         * 
         * @param width  the width of the rectangle
         * @param length the length of the rectangle
         */
        public Rectangle(double width, double length) {
            if (width < 0)
                width = 0;
            if (length < 0)
                length = 0;
            this.width = width;
            this.length = length;
        }

        /**
         * Returns the width of the rectangle.
         * 
         * @return the width of the rectangle
         */
        public double getWidth() {
            return this.width;
        }

        /**
         * Returns the length of the rectangle.
         * 
         * @return the length of the rectangle
         */
        public double getLength() {
            return this.length;
        }

        /**
         * Calculates and returns the area of the rectangle.
         * 
         * @return the area of the rectangle
         */
        public double getArea() {
            return this.width * this.length;
        }
    }

    /**
     * Represents a cuboid, a subclass of Rectangle, with a given height.
     */
    public class Cuboid extends Rectangle {
        private double height;

        /**
         * Constructs a cuboid with the specified width, length, and height.
         * 
         * @param width  the width of the base rectangle of the cuboid
         * @param length the length of the base rectangle of the cuboid
         * @param height the height of the cuboid
         */
        public Cuboid(double width, double length, double height) {
            super(width, length);
            if (height < 0)
                height = 0;
            this.height = height;
        }

        /**
         * Returns the height of the cuboid.
         * 
         * @return the height of the cuboid
         */
        public double getHeight() {
            return this.height;
        }

        /**
         * Calculates and returns the volume of the cuboid.
         * 
         * @return the volume of the cuboid
         */
        public double getVolume() {
            return super.getArea() * this.height;
        }
    }
}
