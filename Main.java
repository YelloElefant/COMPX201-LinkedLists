public class Main {
    public static void main(String[] args) {
        StrLinkedList temp = new StrLinkedList();
        temp.add("1");
        temp.add("2");
        temp.add("3");
        temp.add("4");
        temp.add("5");
        temp.print();
        temp.remove("5");
        temp.print();
    }
}
