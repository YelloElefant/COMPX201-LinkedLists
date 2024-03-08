package LinkedLists;

public class node {
    public int value;
    public node next;

    public node(int value) {
        this.value = value;
        this.next = null;
    }

    public void print() {
        System.out.println("Value: " + value);
    }

    public void printList() {
        node current = this;
        while (current != null) {
            current.print();
            current = current.next;
        }
    }
}
