/**
 * Implementation of NodeList interface using a binary search tree structure.
 * This class manages a sorted structure of ListItems.
 */
public class SearchTree implements NodeList {
    private ListItem root = null;

    /**
     * Constructs a new SearchTree with the specified root ListItem.
     * 
     * @param root The root ListItem of the binary search tree.
     */
    public SearchTree(ListItem root) {
        this.root = root;
    }

    /**
     * Retrieves the root ListItem of the binary search tree.
     * 
     * @return The root ListItem.
     */
    @Override
    public ListItem getRoot() {
        return this.root;
    }

    /**
     * Adds a ListItem to the binary search tree in the appropriate position based
     * on its compareTo method.
     * 
     * @param newItem The ListItem to add.
     * @return true if the ListItem was successfully added, false otherwise.
     */
    @Override
    public boolean addItem(ListItem newItem) {

        if (this.root == null) {
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = (currentItem.compareTo(newItem));
            if (comparison < 0) {
                if (currentItem.next() != null)
                    currentItem = currentItem.next();
                else {
                    currentItem.setNext(newItem);
                    return true;
                }
            } else if (comparison > 0) {
                if (currentItem.previous() != null)
                    currentItem = currentItem.previous();
                else {
                    currentItem.setPrevious(newItem);
                    return true;
                }
            } else {
                System.out.println(newItem.getValue() + " is already present");
                return false;
            }
        }
        return false;
    }

    /**
     * Removes a ListItem from the binary search tree.
     * 
     * @param item The ListItem to remove.
     * @return true if the ListItem was successfully removed, false otherwise.
     */
    @Override
    public boolean removeItem(ListItem item) {

        if (item != null) {
            System.out.println("Deleting item " + item.getValue());
        }
        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;

        while (currentItem != null) {
            int comparison = (currentItem.compareTo(item));
            if (comparison < 0) {
                parentItem = currentItem;
                currentItem = currentItem.next();
            } else if (comparison > 0) {
                parentItem = currentItem;
                currentItem = currentItem.previous();
            } else {
                performRemoval(currentItem, parentItem);
                return true;
            }
        }
        return false;
    }

    /**
     * Helper method to perform the removal of a ListItem from the binary search
     * tree.
     * 
     * @param item   The ListItem to remove.
     * @param parent The parent of the ListItem to remove.
     */
    private void performRemoval(ListItem item, ListItem parent) {
        // remove item from the tree
        if (item.next() == null) {
            if (parent.next() == item)
                parent.setNext(item.previous());
            else if (parent.previous() == item)
                parent.setPrevious(item.previous());
            else
                this.root = item.previous();
        } else if (item.previous() == null) {
            if (parent.next() == item)
                parent.setNext(item.next());
            else if (parent.previous() == item)
                parent.setPrevious(item.next());
            else
                this.root = item.next();
        } else {
            ListItem current = item.next();
            ListItem leftmostParent = item;
            while (current.previous() != null) {
                leftmostParent = current;
                current = current.previous();
            }
            item.setValue(current.getValue());
            if (leftmostParent == item)
                item.setNext(current.next());
            else
                leftmostParent.setPrevious(current.next());
        }
    }

    /**
     * Traverses the binary search tree in-order starting from the specified root
     * ListItem.
     * Prints each ListItem's value in sorted order.
     * 
     * @param root The starting ListItem for traversal.
     */
    @Override
    public void traverse(ListItem root) {
        if (root != null) {
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }
    }
}
