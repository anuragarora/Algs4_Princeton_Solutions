public class Driver {
    public static void main(String args[]){
        Driver driver = new Driver();
        //driver.testFixedCapacityQueue(10);
        //driver.testResizableArrayQueue();
        //driver.testDeque();
        //driver.testRandomizedQueue();
        driver.testDeque2();
    }
    
    public void testDeque2() {
        Deque<Integer> deque = new Deque<>();
        deque.addLast(0);
        System.out.println(deque.removeLast());
        deque.addLast(2);
        System.out.println(deque.removeLast());
        deque.addLast(4);
        System.out.println(deque.removeLast());
        deque.addLast(6);
        System.out.println(deque.isEmpty());
        System.out.println(deque.removeLast());
        System.out.println(deque.isEmpty());
    }
    
    public void testRandomizedQueue() {
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        queue.enqueue("Anurag");
        queue.enqueue("Arora");
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        queue.enqueue("E");
        queue.enqueue("F");
        queue.enqueue("G");
        queue.enqueue("H");
        queue.enqueue("I");
        queue.enqueue("J");
        queue.enqueue("K");
        queue.enqueue("L");
        
        // Printing the collection through an iterator
        for (String string : queue){
            System.out.println(string);
        }
        
        System.out.println("\ndeQueuing items :\n");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        
        System.out.println("\nEnqueuing more items :\n");
        
        queue.enqueue("P");
        queue.enqueue("Q");
        queue.enqueue("R");
        queue.enqueue("S");
        queue.enqueue("T");
        queue.enqueue("U");
        queue.enqueue("V");
        
        for (String string : queue) {
            System.out.println(string);
        }
    }
    
    public void testDeque() {
        Deque<String> deque = new Deque<>();
        deque.addFirst("Anurag");
        deque.addLast("Arora");
        deque.addFirst("A");
        deque.addLast("B");
        deque.addFirst("C");
        deque.addFirst("D");
        deque.addLast("E");
        deque.addFirst("F");
        deque.addLast("G");
        deque.addLast("H");
        deque.addLast("I");
        deque.addLast("J");
        deque.addFirst("K");
        deque.addFirst("L");
        
        // Printing the collection through an iterator
        for (String string : deque){
            System.out.println(string);
        }
        
        System.out.println("\ndeQueuing items :\n");
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeFirst());
        
        System.out.println("\nEnqueuing more items :\n");
        
        deque.addFirst("P");
        deque.addLast("Q");
        deque.addFirst("R");
        deque.addLast("S");
        deque.addFirst("T");
        deque.addLast("U");
        deque.addFirst("V");
        
        for (String string : deque) {
            System.out.println(string);
        }
    }
    
    public void testResizableArrayQueue() {
        ResizingArrayQueue<String> queue = new ResizingArrayQueue<>();
        queue.enQueue("Anurag");
        queue.enQueue("Arora");
        queue.enQueue("A");
        queue.enQueue("B");
        queue.enQueue("C");
        queue.enQueue("D");
        queue.enQueue("E");
        queue.enQueue("F");
        queue.enQueue("G");
        queue.enQueue("H");
        queue.enQueue("I");
        queue.enQueue("J");
        queue.enQueue("K");
        queue.enQueue("L");
        
        // Printing the collection through an iterator
        for (String string : queue){
            System.out.println(string);
        }
        
        System.out.println("\ndeQueuing items :\n");
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        
        System.out.println("\nEnqueuing more items :\n");
        
        queue.enQueue("P");
        queue.enQueue("Q");
        queue.enQueue("R");
        queue.enQueue("S");
        queue.enQueue("T");
        queue.enQueue("U");
        queue.enQueue("V");
        
        for (String string : queue) {
            System.out.println(string);
        }
    }
    
    public void testFixedCapacityQueue(int size) {
        FixedCapacityQueueOfStrings<String> queue = new FixedCapacityQueueOfStrings<>(size);
        queue.enQueue("Anurag");
        queue.enQueue("Arora");
        queue.enQueue("A");
        queue.enQueue("B");
        queue.enQueue("C");
        queue.enQueue("D");
        queue.enQueue("E");
        queue.enQueue("F");
        queue.enQueue("G");
        queue.enQueue("H");
        
        // Printing the collection through an iterator
        for (String string : queue){
            System.out.println(string);
        }
        
        System.out.println("\ndeQueuing items :\n");
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        
        System.out.println("\nEnqueuing more items :\n");
        
        queue.enQueue("P");
        queue.enQueue("Q");
        queue.enQueue("R");
        queue.enQueue("S");
        queue.enQueue("T");
        queue.enQueue("U");
        queue.enQueue("V");
        
        for (String string : queue) {
            System.out.println(string);
        }
    }
}