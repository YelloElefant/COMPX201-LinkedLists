
public class node {
    public String value;
    public node next;

    public node(String value) {
        this.value = value;
        this.next = null;
    }

    public void print() {
        System.out.println("Value: " + value);
    }

    public void printInLine() {
        System.out.print(value + " ");
    }

}
