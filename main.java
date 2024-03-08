package LinkedLists;

import LinkedLists.*;

public class main {
    public static void main(String[] args) {
        StrLinkedList list = new StrLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.print();
        list.add(0);
        list.print();
        list.remove(3);
        list.print();

        System.out.println(list.hasValue(2));

    }
}
