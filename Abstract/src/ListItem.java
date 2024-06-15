/**
 * Abstract class representing an item in a linked structure.
 * Each ListItem holds a value and can be linked to other ListItems.
 */
public abstract class ListItem {
    /** reference to next item */
    protected ListItem rightLink = null;
    /** reference to previous item */
    protected ListItem leftLink = null;

    protected Object value;

    /**
     * Constructor to initialize a ListItem with a given value.
     * 
     * @param value The value to be stored in the ListItem.
     */
    public ListItem(Object value) {
        this.value = value;
    }

    /**
     * Abstract method to get the next ListItem in the sequence.
     * 
     * @return The next ListItem in the sequence, or null if none exists.
     */
    abstract ListItem next();

    /**
     * Abstract method to set the next ListItem in the sequence.
     * 
     * @param item The ListItem to be set as the next one.
     * @return The ListItem that was set as the next one.
     */
    abstract ListItem setNext(ListItem item);

    /**
     * Abstract method to get the previous ListItem in the sequence.
     * 
     * @return The previous ListItem in the sequence, or null if none exists.
     */
    abstract ListItem previous();

    /**
     * Abstract method to set the previous ListItem in the sequence.
     * 
     * @param item The ListItem to be set as the previous one.
     * @return The ListItem that was set as the previous one.
     */
    abstract ListItem setPrevious(ListItem item);

    /**
     * Abstract method to compare this ListItem with another ListItem.
     * 
     * @param item The ListItem to compare with.
     * @return A negative integer, zero, or a positive integer as this ListItem
     *         is less than, equal to, or greater than the specified ListItem.
     */
    abstract int compareTo(ListItem item);

    /**
     * Method to get the value stored in this ListItem.
     * 
     * @return The value stored in this ListItem.
     */
    public Object getValue() {
        return value;
    }

    /**
     * Method to set the value stored in this ListItem.
     * 
     * @param value The value to be stored in this ListItem.
     */
    public void setValue(Object value) {
        this.value = value;
    }
}