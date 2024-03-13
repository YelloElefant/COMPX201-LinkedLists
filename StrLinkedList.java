/**
 * StrLinkedList class
 * 
 * This class is used to create a linked list of strings
 * 
 * @version 1.0
 * @since 2024-03-13
 * @author Alexander Trotter
 */
public class StrLinkedList {
    /**
     * The head node of the linked list
     */
    public node head;

    /**
     * Constructor for the StrLinkedList class
     */
    public StrLinkedList() {
        this.head = null;
    }

    /**
     * Method to get the length of the linked list
     * 
     * @return int - the length of the linked list
     */
    public int getLength() {
        node current = this.head;
        int count = 0;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    /**
     * Method to check if the linked list is empty
     * 
     * @return boolean - true if the linked list is empty, false otherwise
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * Method to get the value at a specific index in the linked list
     * 
     * @param index - the index to get the value from
     * @return String - the value at the index
     */
    public String getValueAt(int index) {
        node current = this.head;
        int count = 0;

        while (current != null) {
            if (count == index) {
                return current.value;
            }

            count++;
            current = current.next;

        }
        throw new IndexOutOfBoundsException("Index does not exsist in the list");
    }

    /**
     * Method to check if the linked list contains a specific value
     * 
     * @param value - the value to check for
     * @return boolean - true if the value is in the linked list, false otherwise
     */
    public boolean hasValue(String value) {
        node current = this.head;

        while (current != null) {
            if (current.value == value) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    /**
     * Method to add a value to the linked list
     * 
     * @param value - the value to add
     */
    public void add(String value) {
        node newHead = new node(value);
        newHead.next = this.head;
        this.head = newHead;
    }

    /**
     * Method to remove a value from the linked list
     * 
     * @param value - the value to remove
     */
    public void remove(String value) {
        if (this.head == null) {
            return;
        }

        if (this.head.value == value) {
            this.head = this.head.next;
            return;
        }

        node current = this.head;

        while (current.next != null) {
            if (current.next.value == value) {
                current.next = current.next.next;
                return;
            }

            current = current.next;
        }
    }

    /**
     * Method to print the linked list
     */
    public void print() {
        node current = this.head;
        while (current != null) {
            current.print();
            current = current.next;
        }
    }

    /**
     * Method to print the linked list in line
     */
    public void printInLine() {
        node current = this.head;
        while (current != null) {
            current.printInLine();
            current = current.next;
        }
        System.out.println('\n');
    }

}
