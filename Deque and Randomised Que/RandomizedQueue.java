import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Node mHead;
    private Node mTail;
    private int mCurrentSize;
    
    private class Node {
        private final Item item;
        private Node next;
        private Node previous;
        public Node(Item item) {
            this.item = item;
            this.next = null;
            this.previous = null;
        }
    }
    
    /**
     * Construct an empty randomized queue 
     */
    public RandomizedQueue() {
        mHead = null;
        mTail = null;
        this.mCurrentSize = 0;
    }
   
    /**
     * Is the randomized queue empty?
     */
    public boolean isEmpty() {
        return mCurrentSize == 0;
    }
   
    /**
     * Return the number of items on the randomized queue
     */
    public int size() {
        return mCurrentSize;
    }
    
    /**
     * Add the item
     */
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (mHead == null) {
            mHead = new Node(item);
            mTail = mHead;
        }
        else {
            Node oldHead = mHead;
            mHead = new Node(item);
            mHead.next = oldHead;
            oldHead.previous = mHead;
        }
        mCurrentSize++;
    }
   
   /**
    * Remove and return a random item
    */
    public Item dequeue() {
        Node randomNode = getRandomNode();
        
        // Removing randomly selected node
        if (mHead == mTail) {
            mHead = null;
            mTail = null;
        }
        else if (randomNode == mHead) {
            mHead = mHead.next;
            mHead.previous = null;
        }
        else if (randomNode == mTail) {
            mTail = mTail.previous;
            mTail.next = null;
        }
        else {
            randomNode.previous.next = randomNode.next;
            randomNode.next.previous = randomNode.previous;
        }
        mCurrentSize--;
        return randomNode.item;
    }
    
    private Node getRandomNode() {
        if (mHead == null || mTail == null) {
            throw new NoSuchElementException();
        }
        int count = 0;
        Node current;
        int index = StdRandom.uniform(0, mCurrentSize);
        if (index > mCurrentSize / 2) {
            current = mTail;
            index = mCurrentSize - index;
            while (count != index) {
                current = current.previous;
                count++;
            }
        }
        else {
            current = mHead;
            while (count != index) {
                current = current.next;
                count++;
            }
        }
        return current;
    }
    
    /**
     * Return a random item (but do not remove it)
     */
    public Item sample() {
        Node randomNode = getRandomNode();
        return randomNode.item;
    }
    
    /**
     * Return an independent iterator over items in random order
     */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    
    private class ListIterator implements Iterator<Item> {
        private Node walk = mHead;
        public void remove() {
            throw new UnsupportedOperationException();
        }
        
        public boolean hasNext() {
            return walk != null;
        }
        
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item valueToReturn = walk.item;
            walk = walk.next;
            return valueToReturn;
        }
    }
}