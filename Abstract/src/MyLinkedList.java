/**
 * Implementation of NodeList interface using a linked list structure.
 * This class manages a sequence of ListItems.
 */
public class MyLinkedList implements NodeList {
    private ListItem root = null;

    /**
     * Constructs a new MyLinkedList with the specified root ListItem.
     * 
     * @param root The root ListItem of the linked list.
     */
    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    /**
     * Retrieves the root ListItem of the linked list.
     * 
     * @return The root ListItem.
     */
    @Override
    public ListItem getRoot() {
        return this.root;
    }

    /**
     * Adds a ListItem to the linked list in the appropriate order based on its
     * compareTo method.
     * 
     * @param item The ListItem to add.
     * @return true if the ListItem was successfully added, false otherwise.
     */
    @Override
    public boolean addItem(ListItem item) {
        if (this.root == null) {
            this.root = item;
            return true;
        } else {
            ListItem current = this.root;
            while (current != null) {
                int comparison = current.compareTo(item);
                if (comparison < 0) {
                    if (current.next() != null) {
                        current = current.next();
                    } else {
                        current.setNext(item).setPrevious(current);
                        return true;
                    }
                } else if (comparison > 0) {
                    if (current.previous() != null) {
                        current.previous().setNext(item).setPrevious(current.previous());
                        item.setNext(current.setPrevious(item));
                    } else {
                        item.setNext(this.root).setPrevious(item);
                        this.root = item;
                    }
                    return true;
                } else
                    return false;
            }
        }
        return false;
    }

    /**
     * Removes a ListItem from the linked list.
     * 
     * @param item The ListItem to remove.
     * @return true if the ListItem was successfully removed, false otherwise.
     */
    @Override
    public boolean removeItem(ListItem item) {

        if (item != null)
            System.out.println("Deleting item " + item.getValue());

        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if (comparison == 0) {
                // found the item to delete
                if (currentItem == this.root)
                    this.root = currentItem.next();
                else {
                    currentItem.previous().setNext(currentItem.next());
                    if (currentItem.next() != null)
                        currentItem.next().setPrevious(currentItem.previous());
                }
                return true;
            } else if (comparison < 0)
                currentItem = currentItem.next();
            else
                return false;
        }
        return false;
    }

    /**
     * Traverses the linked list starting from the specified root ListItem.
     * Prints each ListItem's value in sequence.
     * 
     * @param root The starting ListItem for traversal.
     */
    @Override
    public void traverse(ListItem root) {
        if (root == null)
            System.out.println("The list is empty");
        else {
            ListItem current = root;
            while (current != null) {
                System.out.println(current.getValue());
                current = current.next();
            }
        }
    }

}
