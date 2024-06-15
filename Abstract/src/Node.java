/**
 * A concrete implementation of ListItem representing a node in a linked
 * structure.
 * Each Node holds a value and can be linked to other Nodes.
 */
public class Node extends ListItem {

    /**
     * Constructs a new Node with the specified value.
     * 
     * @param value The value to be stored in the Node.
     */
    public Node(Object value) {
        super(value);
    }

    /**
     * Retrieves the next ListItem (Node) linked from this Node.
     * 
     * @return The next ListItem in the sequence, or null if there is none.
     */
    @Override
    public ListItem next() {
        return this.rightLink;
    }

    /**
     * Sets the next ListItem (Node) to be linked from this Node.
     * 
     * @param rightLink The ListItem (Node) to be set as the next one.
     * @return The ListItem (Node) that was set as the next one.
     */
    @Override
    public ListItem setNext(ListItem rightLink) {
        this.rightLink = rightLink;
        return this.rightLink;
    }

    /**
     * Retrieves the previous ListItem (Node) linked to this Node.
     * 
     * @return The previous ListItem in the sequence, or null if there is none.
     */
    @Override
    public ListItem previous() {
        return this.leftLink;
    }

    /**
     * Sets the previous ListItem (Node) to be linked to this Node.
     * 
     * @param leftLink The ListItem (Node) to be set as the previous one.
     * @return The ListItem (Node) that was set as the previous one.
     */
    @Override
    public ListItem setPrevious(ListItem leftLink) {
        this.leftLink = leftLink;
        return this.leftLink;
    }

    /**
     * Compares this Node's value with the value of another ListItem.
     * 
     * @param item The ListItem (Node) to compare with.
     * @return A negative integer, zero, or a positive integer if this Node's
     *         value is less than, equal to, or greater than the specified Node's
     *         value.
     *         Returns -1 if the provided item is null.
     */
    @Override
    public int compareTo(ListItem item) {
        if (item != null)
            return ((String) this.getValue()).compareTo((String) item.getValue());
        else
            return -1;
    }
}
