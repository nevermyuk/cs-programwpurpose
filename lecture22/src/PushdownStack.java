public class PushdownStack<Item> {
    // Instance variable
    private Node first = null;
    private int N = 0;

    // Nested class
    private class Node {
        private Item item; // use in place of concrete types, to hold any type of data
        private Node next;
    }

    // Method
    public boolean isEmpty() {
        return first == null;
    }

    public void push(Item item) {
        Node second = first;
        first = new Node();
        first.item = item;
        first.next = second;
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public int size() {
        return N;
    }

    // Test client
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (item.equals("-"))
                System.out.print(stack.pop() + " ");
            else
                stack.push(item);
        }
        StdOut.println();
    }
}
