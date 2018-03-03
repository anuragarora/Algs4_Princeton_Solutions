public class LinkedQueueofStrings {
    private Node first, last;
    
    private class Node {
        String item;
        Node next;
    }
    
    public void enQueue(String stringtoEnqueue){
        Node oldLast = last;
        last = new Node();
        last.item = stringtoEnqueue;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }
    
    public String deQueue() {
        String value = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        return value;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
}