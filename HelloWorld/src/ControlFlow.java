public class ControlFlow {
    public static void main(String[] args) {
        // System.out.println(sumFirstAndLastDigit(-202));
        // System.out.println(getEvenDigitSum(123456789));
        // System.out.println(hasSameLastDigit(11, 22, 31));
    }


    // exercise 13
    /**
     * Prints the word representation of the given number.
     * If the number is between 0 and 9 (inclusive), prints the word representation
     * of that number.
     * If the number is outside this range, prints "OTHER".
     *
     * @param number the number to convert to word representation
     */
    public static void printNumberInWord(int number) {
        String word = switch (number) {
            case 0 -> "ZERO";
            case 1 -> "ONE";
            case 2 -> "TWO";
            case 3 -> "THREE";
            case 4 -> "FOUR";
            case 5 -> "FIVE";
            case 6 -> "SIX";
            case 7 -> "SEVEN";
            case 8 -> "EIGHT";
            case 9 -> "NINE";
            default -> "OTHER";
        };

        System.out.println(word);
    }


    // exercise 14
    /**
     * Returns the number of days in the specified month of the given year.
     * If the month or year is out of range, returns -1.
     *
     * @param month the month (1 for January, 2 for February, ..., 12 for December)
     * @param year  the year
     * @return the number of days in the specified month of the given year, or -1 if
     *         month or year is out of range
     */
    public static int getDaysInMonth(int month, int year) {
    // if month or year out of range
    if (month < 1 || month > 12)
    return -1;
    if (year < 1 || year > 9999)
    return -1;

    int days = switch (month) {
    // february = 28
    case 2 -> 28;

    // april, june, sept, or nov = 30
    case 4, 6, 9, 11 -> 30;

    // else 31
    default -> 31;
    };

    // if leap year and month of february, increment days by 1
    boolean isLeapYear = FirstClass.isLeapYear(year);
    if (month == 2 && isLeapYear)
    days++;

    return days;
    }


    // exercise 15
    /**
     * Checks if the given number is odd.
     *
     * @param number the number to check
     * @return true if the number is odd, false otherwise
     */
    public static boolean isOdd(int number) {
        if (number <= 0)
            return false;

        return (number % 2 == 1);
    }

    /**
     * Sums all odd numbers within the specified range [start, end].
     *
     * @param start the start of the range (inclusive)
     * @param end   the end of the range (inclusive)
     * @return the sum of all odd numbers within the range, or -1 if the range is
     *         invalid
     */
    public static int sumOdd(int start, int end) {
        if (end < start || start <= 0 || end <= 0)
            return -1;

        int sum = 0;
        for (int current = start; current <= end; current++) {
            if (isOdd(current))
                sum += current;
        }

        return sum;
    }


    // exercise 16
    /**
     * Determines whether a given integer is a palindrome.
     * A palindrome is a number that reads the same backward as forward.
     *
     * @param number The integer to check for palindrome property.
     * @return True if the number is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(int number) {

        int reverseNumber = 0, remainder;

        // initialize loop starting from number
        // condition of i != 0
        // so method can be used for positive or negative numbers
        // modify i by /= 10 to move through the digits of number
        for (int i = number; i != 0; i /= 10) {

            // find the last digit and append to reverseNumber
            remainder = i % 10;
            reverseNumber = reverseNumber * 10 + remainder;
        }

        // return comparison between number and its reverse
        return (number == reverseNumber);
    }


    // exercise 17
    /**
     * Calculates the sum of the first and last digits of a given positive number.
     *
     * @param number The positive number for which to find the sum of the first and
     *               last digits.
     * @return The sum of the first and last digits of the given number.
     *         If the input number is negative, returns -1 to indicate an invalid
     *         input.
     */
    public static int sumFirstAndLastDigit(int number) {
        // scope is positive numbers only
        if (number < 0)
            return -1;

        // find last digit with modulo
        int lastDigit = number % 10;

        // starting at number, use while loop to modify until firstDigit
        int firstDigit = number;
        while (firstDigit > 9) {
            firstDigit /= 10;
        }

        // calculate sum and return
        return firstDigit + lastDigit;
    }


    // exercise 18
    /**
     * Calculates the sum of even digits in a given positive number.
     *
     * @param number The positive number for which to find the sum of even digits.
     * @return The sum of even digits in the given number.
     *         If the input number is negative, returns -1 to indicate an invalid
     *         input.
     */
    public static int getEvenDigitSum(int number) {
        // scope is positive numbers only
        if (number < 0)
            return -1;

        // initialize return variable, and helper to get individual digits of the number
        int sum = 0;
        int digit = 0;

        // initialize loop starting from number
        // modify i by /= 10 to move through the digits of number
        for (int i = number; i > 0; i /= 10) {
            // find each digit
            digit = i % 10;

            // if the digit is odd, move to next iteration
            if (digit % 2 == 1)
                continue;
            // else add to sum, then continue looping
            else
                sum += digit;
        }

        return sum;
    }


    // exercise 19
    /**
     * Checks if two given two-digit positive numbers share at least one digit.
     *
     * @param first  The first two-digit positive number.
     * @param second The second two-digit positive number.
     * @return True if the two numbers share at least one digit, false otherwise.
     *         If either of the input numbers is not a two-digit positive number,
     *         returns false to indicate invalid input.
     */
    public static boolean hasSharedDigit(int first, int second) {
        // scope is positive numbers in between 10 and 99 inclusive
        if ((first < 10 || first > 99) || (second < 10 || second > 99))
            return false;

        // since scope is two digit numbers only
        // find first and last digit of both numbers
        int firstLeft = first / 10, firstRight = first % 10;
        int secondLeft = second / 10, secondRight = second % 10;

        // compare digits and return
        return (firstLeft == secondLeft || firstLeft == secondRight)
                || (secondLeft == firstRight || secondRight == firstRight);
    }


    // exercise 20
    /**
     * Checks if at least two out of three given positive numbers have the same last
     * digit.
     *
     * @param first  The first positive number.
     * @param second The second positive number.
     * @param third  The third positive number.
     * @return True if at least two out of the three numbers have the same last
     *         digit, false otherwise.
     *         If any of the input numbers is not a positive number between 10 and
     *         1000 (inclusive),
     *         returns false to indicate invalid input.
     */
    public static boolean hasSameLastDigit(int first, int second, int third) {
        // scope is positive numbers in between 10 and 1000 inclusive
        if (!isValid(first) || !isValid(second) || !isValid(third))
            return false;

        // determine last digits of each of the three numbers
        int firstLastDigit = first % 10;
        int secondLastDigit = second % 10;
        int thirdLastDigit = third % 10;

        // return comparison --> returns true if at least 2 of the 3 digits are the same
        return (firstLastDigit == secondLastDigit) || (secondLastDigit == thirdLastDigit)
                || (firstLastDigit == thirdLastDigit);
    }

    /**
     * Checks if a given number is a positive number between 10 and 1000
     * (inclusive).
     *
     * @param number The number to check.
     * @return True if the number is a positive number between 10 and 1000
     *         (inclusive), false otherwise.
     */
    public static boolean isValid(int number) {
        return (number >= 10 && number <= 1000);
    }
}
