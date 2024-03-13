/**
 * node class
 * 
 * This class is used to create a node for a linked list
 * 
 * @since 2024-03-13
 * @version 1.0
 * @author Alexander Trotter
 * 
 */
public class node {
    /**
     * The value of the node
     */
    public String value;

    /**
     * The next node in the linked list
     */
    public node next;

    /**
     * Constructor for the node class
     * 
     * @param value - the value of the node
     */
    public node(String value) {
        this.value = value;
        this.next = null;
    }

    /**
     * Method to print the value of the node
     */
    public void print() {
        System.out.println("Value: " + value);
    }

    /**
     * Method to print the value of the node in line
     */
    public void printInLine() {
        System.out.print(value);
    }

}
