public class Driver {
    public static void main(String args[]){
        Driver driver = new Driver();
        //driver.testFixedCapacityQueue(10);
        driver.testResizableArrayQueue();
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