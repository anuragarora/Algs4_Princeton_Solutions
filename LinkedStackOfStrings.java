public class LinkedStackOfStrings {
    private Node first = null;
    
    // Innerclass so that we can directly reference instance variables
    // first is the only instance variable for Stack
    private class Node {
        String item;
        Node next;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    public void push(String stringToPush) {
        Node oldfirst = first;
        first = new Node();
        first.item = stringToPush;
        first.next = oldfirst;
    }
    
    /**
     * No underflow check implemented ...
     */
    public String pop(){
        String item = first.item;
        first = first.next;
        return item;
    }
}