public class PolymorphismOOP {
    public void main() {

    }

    // exercise 38
    /**
     * Represents a lamp.
     */
    public class Lamp {
        private String style;
        private boolean battery;
        private int globRating;

        /**
         * Constructs a Lamp object with the specified parameters.
         * 
         * @param style      The style of the lamp
         * @param battery    Indicates whether the lamp has a battery
         * @param globRating The rating of the lamp's globe
         */
        public Lamp(String style, boolean battery, int globRating) {
            this.style = style;
            this.battery = battery;
            this.globRating = globRating;
        }

        /**
         * Gets the style of the lamp.
         * 
         * @return The style of the lamp
         */
        public String getStyle() {
            return this.style;
        }

        /**
         * Checks if the lamp has a battery.
         * 
         * @return True if the lamp has a battery, otherwise false
         */
        public boolean isBattery() {
            return this.battery;
        }

        /**
         * Gets the rating of the lamp's globe.
         * 
         * @return The rating of the lamp's globe
         */
        public int getGlobRating() {
            return this.globRating;
        }

        /**
         * Turns on the lamp.
         */
        public void turnOn() {
            System.out.print("Lamp -> Turning on");
        }
    }

    /**
     * Represents a bed.
     */
    public class Bed {
        private String style;
        private int pillows;
        private int height;
        private int sheets;
        private int quilt;

        /**
         * Constructs a Bed object with the specified parameters.
         * 
         * @param style   The style of the bed
         * @param pillows The number of pillows on the bed
         * @param height  The height of the bed
         * @param sheets  The number of sheets on the bed
         * @param quilt   The number of quilts on the bed
         */
        public Bed(String style, int pillows, int height, int sheets, int quilt) {
            this.style = style;
            this.pillows = pillows;
            this.height = height;
            this.sheets = sheets;
            this.quilt = quilt;
        }

        /**
         * Gets the style of the bed.
         * 
         * @return The style of the bed
         */
        public String getStyle() {
            return this.style;
        }

        /**
         * Gets the number of pillows on the bed.
         * 
         * @return The number of pillows on the bed
         */
        public int getPillows() {
            return this.pillows;
        }

        /**
         * Gets the height of the bed.
         * 
         * @return The height of the bed
         */
        public int getHeight() {
            return this.height;
        }

        /**
         * Gets the number of sheets on the bed.
         * 
         * @return The number of sheets on the bed
         */
        public int getSheets() {
            return this.sheets;
        }

        /**
         * Gets the number of quilts on the bed.
         * 
         * @return The number of quilts on the bed
         */
        public int getQuilt() {
            return this.quilt;
        }

        /**
         * Makes the bed.
         */
        public void make() {
            System.out.print("Bed -> Making | ");
        }
    }

    /**
     * Represents a ceiling.
     */
    public class Ceiling {
        private int height;
        private int paintedColor;

        /**
         * Constructs a Ceiling object with the specified parameters.
         * 
         * @param height       The height of the ceiling
         * @param paintedColor The color painted on the ceiling
         */
        public Ceiling(int height, int paintedColor) {
            this.height = height;
            this.paintedColor = paintedColor;
        }

        /**
         * Gets the height of the ceiling.
         * 
         * @return The height of the ceiling
         */
        public int getHeight() {
            return this.height;
        }

        /**
         * Gets the color painted on the ceiling.
         * 
         * @return The color painted on the ceiling
         */
        public int getPaintedColor() {
            return this.paintedColor;
        }
    }

    /**
     * Represents a wall.
     */
    public class Wall {
        private String direction;

        /**
         * Constructs a Wall object with the specified parameters.
         * 
         * @param direction The direction of the wall
         */
        public Wall(String direction) {
            this.direction = direction;
        }

        /**
         * Gets the direction of the wall.
         * 
         * @return The direction of the wall
         */
        public String getDirection() {
            return this.direction;
        }
    }

    /**
     * Represents a bedroom.
     */
    public class Bedroom {
        private String name;
        private Wall wall1;
        private Wall wall2;
        private Wall wall3;
        private Wall wall4;
        private Ceiling ceiling;
        private Bed bed;
        private Lamp lamp;

        /**
         * Constructs a Bedroom object with the specified parameters.
         * 
         * @param name    The name of the bedroom
         * @param wall1   The first wall of the bedroom
         * @param wall2   The second wall of the bedroom
         * @param wall3   The third wall of the bedroom
         * @param wall4   The fourth wall of the bedroom
         * @param ceiling The ceiling of the bedroom
         * @param bed     The bed in the bedroom
         * @param lamp    The lamp in the bedroom
         */
        public Bedroom(String name, Wall wall1, Wall wall2, Wall wall3, Wall wall4, Ceiling ceiling, Bed bed,
                Lamp lamp) {
            this.name = name;
            this.wall1 = wall1;
            this.wall2 = wall2;
            this.wall3 = wall3;
            this.wall4 = wall4;
            this.ceiling = ceiling;
            this.bed = bed;
            this.lamp = lamp;
        }

        /**
         * Gets the lamp in the bedroom.
         * 
         * @return The lamp in the bedroom
         */
        public Lamp getLamp() {
            return this.lamp;
        }

        /**
         * Makes the bed in the bedroom.
         */
        public void makeBed() {
            System.out.print("Bedroom -> Making bed | ");
            this.bed.make();
        }
    }

    // exercise 39
    /**
     * The Printer class simulates a basic printer with toner level tracking,
     * page printing functionality, and support for duplex printing.
     */
    public class Printer {
        private int tonerLevel;
        private int pagesPrinted;
        private boolean duplex;

        /**
         * Constructs a new Printer object with the given toner level and duplex
         * setting.
         *
         * @param tonerLevel The initial toner level of the printer (0 to 100).
         *                   If the provided toner level is outside this range,
         *                   -1 is set to indicate an error.
         * @param duplex     A boolean value indicating whether the printer supports
         *                   duplex printing.
         */
        public Printer(int tonerLevel, boolean duplex) {
            if (tonerLevel < -1 || tonerLevel > 100)
                this.tonerLevel = -1;
            else
                this.tonerLevel = tonerLevel;

            this.pagesPrinted = 0;
            this.duplex = duplex;
        }

        /**
         * Adds toner to the printer, updating the toner level.
         *
         * @param tonerAmount The amount of toner to add (1 to 100).
         * @return The updated toner level after adding toner, or -1 if the toner amount
         *         is invalid
         *         or exceeds the maximum toner level.
         */
        public int addToner(int tonerAmount) {
            if (tonerAmount <= 0 || tonerAmount > 100 || this.tonerLevel + tonerAmount > 100)
                return -1;
            this.tonerLevel += tonerAmount;
            return this.tonerLevel;
        }

        /**
         * Simulates printing a certain number of pages.
         *
         * @param pages The number of pages to print.
         * @return The actual number of pages printed.
         */
        public int printPages(int pages) {
            int pagesToPrint = this.duplex ? pages / 2 + pages % 2 : pages;
            this.pagesPrinted += pagesToPrint;
            return pagesToPrint;
        }

        /**
         * Retrieves the total number of pages printed by the printer.
         *
         * @return The total number of pages printed.
         */
        public int getPagesPrinted() {
            return this.pagesPrinted;
        }
    }
}
