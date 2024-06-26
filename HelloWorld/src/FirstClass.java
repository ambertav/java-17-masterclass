public class FirstClass {
    public static void main(String[] args) {
    }

    // exercise 1
    /**
     * Prints a message indicating whether the given number is positive, negative,
     * or zero.
     * 
     * @param number The number to be checked.
     */
    public static void checkNumber(int number) {
        if (number > 0)
            System.out.println("positive");
        else if (number < 0)
            System.out.println("negative");
        else if (number == 0)
            System.out.println("zero");
    }

    // exercise 2
    /**
     * Converts kilometers per hour to miles per hour.
     * 
     * @param kilometersPerHour The speed in kilometers per hour.
     * @return The speed in miles per hour, or -1 if the input is negative.
     */
    public static long toMilesPerHour(double kilometersPerHour) {
        if (kilometersPerHour < 0)
            return -1l;

        return Math.round(kilometersPerHour / 1.609);
    }

    /**
     * Prints a conversion of speed from kilometers per hour to miles per hour.
     * 
     * @param kilometersPerHour The speed in kilometers per hour to be converted.
     */
    public static void printConversion(double kilometersPerHour) {
        if (kilometersPerHour < 0)
            System.out.println("Invalid Value");
        else {
            long milesPerHour = toMilesPerHour(kilometersPerHour);

            System.out.println(kilometersPerHour + " km/h = " + milesPerHour + " mi/h");
        }
    }

    // exercise 3
    /**
     * Prints the conversion of kilobytes to megabytes and remaining kilobytes.
     * 
     * @param kiloBytes The size in kilobytes to be converted and printed.
     */
    public static void printMegaBytesAndKiloBytes(int kiloBytes) {
        if (kiloBytes < 0)
            System.out.println("Invalid Value");
        else {
            // 1mb = 1024kb
            long megaBytes = kiloBytes / 1024;
            int remainingKiloBytes = kiloBytes % 1024;

            System.out.println(kiloBytes + " KB = " + megaBytes + " MB and " + remainingKiloBytes + " KB");
        }
    }

    // exercise 4
    /**
     * Determines whether the dog should wake up its owner.
     * 
     * @param isBarking Indicates if the dog is barking (true/false).
     * @param hourOfDay The hour of the day (0-23).
     * @return true if the dog should wake up its owner, false otherwise.
     */
    public static boolean shouldWakeUp(boolean isBarking, int hourOfDay) {
        if (hourOfDay < 0 || hourOfDay > 23)
            return false;
        else
            return (hourOfDay < 8 || hourOfDay > 22) && isBarking;
    }

    // exercise 5
    /**
     * Checks if the given year is a leap year.
     * 
     * @param year The year to be checked.
     * @return true if the year is a leap year, false otherwise.
     */
    public static boolean isLeapYear(int year) {
        // if year is out of range, return false
        if (year < 1 || year > 9999)
            return false;

        // returns true if :
        // year is evenly divisible by 4 AND 100, OR by 400
        else
            return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
    }

    // exercise 6
    /**
     * Compares two double values up to three decimal places.
     * 
     * @param valueOne The first double value to be compared.
     * @param valueTwo The second double value to be compared.
     * @return true if the values are equal up to three decimal places, false
     *         otherwise.
     */
    public static boolean areEqualByThreeDecimalPlaces(double valueOne, double valueTwo) {
        // casting to long, multiplying by 1000 to get first three decimal places
        long roundedValueOne = (long) (valueOne * 1000);
        long roundedValueTwo = (long) (valueTwo * 1000);

        // returning boolean comparison
        return roundedValueOne == roundedValueTwo;
    }

    // exercise 7
    /**
     * Checks if the sum of the first two integers is equal to the third integer.
     * 
     * @param first  The first integer.
     * @param second The second integer.
     * @param third  The third integer.
     * @return true if the sum of first and second is equal to third, false
     *         otherwise.
     */
    public static boolean hasEqualSum(int first, int second, int third) {
        return first + second == third;
    }

    // exercise 8
    /**
     * Checks if any of the three numbers is a teen age (between 13 and 19,
     * inclusive).
     * 
     * @param first  The first number to be checked.
     * @param second The second number to be checked.
     * @param third  The third number to be checked.
     * @return true if any of the numbers is a teen age, false otherwise.
     */
    public static boolean hasTeen(int first, int second, int third) {
        return ((first >= 13 && first <= 19)
                || (second >= 13 && second <= 19)
                || (third >= 13 && third <= 19));
    }

    /**
     * Checks if the given age is a teen age (between 13 and 19, inclusive).
     * 
     * @param age The age to be checked.
     * @return true if the age is a teen age, false otherwise.
     */
    public static boolean isTeen(int age) {
        return age >= 13 && age <= 19;
    }

    // exercise 9
    /**
     * Calculates the area of a circle given its radius.
     * 
     * @param radius The radius of the circle.
     * @return The area of the circle, or -1 if the radius is negative.
     */
    public static double circleArea(double radius) {
        if (radius < 0)
            return -1d;
        else
            return Math.PI * Math.pow(radius, 2);
    }

    /**
     * Calculates the area of a rectangle given its dimensions.
     * 
     * @param x The length of one side of the rectangle.
     * @param y The length of the other side of the rectangle.
     * @return The area of the rectangle, or -1 if either dimension is negative.
     */
    public static double rectangleArea(double x, double y) {
        if (x < 0 || y < 0)
            return -1d;
        else
            return x * y;
    }

    // exercise 10
    /**
     * Converts the given number of minutes into years and remaining days.
     * 
     * @param minutes The number of minutes to be converted.
     */
    public static void printYearsAndDays(long minutes) {
        if (minutes < 0)
            System.out.println("Invalid Value");
        else {
            long hours = minutes / 60; // minutes to hours
            long days = hours / 24; // hours to days
            long years = days / 365; // days to years

            // days remaining from days to whole years conversion
            long daysRemainder = days % 365;

            System.out.println(minutes + " min = " + years + " y and " + daysRemainder + " d");
        }
    }

    // exercise 11
    /**
     * Compares three integers and prints a message indicating their comparison.
     * 
     * @param first  The first integer.
     * @param second The second integer.
     * @param third  The third integer.
     */
    public static void printEqual(int first, int second, int third) {
        if (first < 0 || second < 0 || third < 0)
            System.out.println("Invalid Value");
        else {
            if (first == second && second == third)
                System.out.println("All numbers are equal");
            else if (first != second && second != third && first != third)
                System.out.println("All numbers are different");
            else
                System.out.println("Neither all are equal or different");
        }
    }

    // exercise 12
    /**
     * Checks if a cat is playing based on the current season and temperature.
     * 
     * @param isSummer    Indicates whether it's summer (true) or not (false).
     * @param temperature The temperature in Celsius.
     * @return true if the cat is playing, false otherwise.
     */
    public static boolean isCatPlaying(boolean isSummer, int temperature) {
        // true if temp between 25 and 35 inclusive, or if in summer, 25 to 45 inclusive
        return ((isSummer && temperature >= 25 && temperature <= 45)
                || (!isSummer && temperature >= 25 && temperature <= 35));
    }
}
