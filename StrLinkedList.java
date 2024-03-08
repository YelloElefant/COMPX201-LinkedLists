package LinkedLists;

import java.util.random.*;
import LinkedLists.node;

public class StrLinkedList {
    public node head;

    public StrLinkedList() {
        this.head = null;
    }

    // isEmpty method
    public boolean isEmpty() {
        return this.head == null;
    }

    // make has value at index method
    public int getValueAt(int index) {
        node current = this.head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current.value;
            }
            count++;
            current = current.next;
        }
        return -1;
    }

    // make has value method
    public boolean hasValue(int value) {
        node current = this.head;
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void add(int value) {
        node newHead = new node(value);
        newHead.next = this.head;
        this.head = newHead;
    }

    public void remove(int value) {
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

    public void print() {
        node current = this.head;
        while (current != null) {
            current.print();
            current = current.next;
        }
    }

}
