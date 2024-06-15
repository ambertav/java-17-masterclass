/**
 * Interface representing a list of nodes that can hold ListItem objects.
 * Implementations of this interface manage a hierarchical structure of
 * ListItems.
 */
public interface NodeList {
    /**
     * Retrieves the root ListItem of the NodeList.
     * 
     * @return The root ListItem of the NodeList.
     */
    abstract ListItem getRoot();

    /**
     * Adds a ListItem to the NodeList.
     * 
     * @param item The ListItem to be added.
     * @return true if the ListItem was successfully added, false otherwise.
     */
    abstract boolean addItem(ListItem item);

    /**
     * Removes a ListItem from the NodeList.
     * 
     * @param item The ListItem to be removed.
     * @return true if the ListItem was successfully removed, false otherwise.
     */
    abstract boolean removeItem(ListItem item);

    /**
     * Traverses the NodeList starting from the specified root ListItem.
     * This method performs an action for each ListItem in the NodeList.
     * 
     * @param root The root ListItem from which to start the traversal.
     */
    abstract void traverse(ListItem root);
}
