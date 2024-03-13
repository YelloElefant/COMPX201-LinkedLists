public class Main {
    public static void main(String[] args) {
        StrLinkedList temp = new StrLinkedList();
        temp.add("1");
        System.err.println(temp.getLength());
        try {

            var tmp = temp.getValueAt(5);
        } catch (Exception e) {
            System.err.println(e);
        }

    }
}
