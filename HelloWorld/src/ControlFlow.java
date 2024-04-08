public class ControlFlow {
    public static void main(String[] args) {
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
}
