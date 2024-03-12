
public class LinkedList {
    public node head;

    public LinkedList() {
        this.head = null;
    }

    // get length method
    public int getLength() {
        node current = this.head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // isEmpty method
    public boolean isEmpty() {
        return this.head == null;
    }

    // make has value method
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

    public void add(String value) {
        node newHead = new node(value);
        newHead.next = this.head;
        this.head = newHead;
    }

}
