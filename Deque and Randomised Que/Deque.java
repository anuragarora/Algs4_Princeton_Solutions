import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
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
     * Construct an empty deque
     */
    public Deque() {
        mHead = null;
        mTail = null;
        mCurrentSize = 0;
    }
    
    /**
     * is the deque empty?
     */
    public boolean isEmpty() {
        return mCurrentSize == 0;
    }
    
    /**
     * Return the number of items on the deque
     */
    public int size() {
        return mCurrentSize;
    }
    
    /**
     * Add the item to the front
     */
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (mTail == null) {
            mHead = new Node(item);
            mTail = mHead;
        } 
        else {
            Node oldHead = mHead;
            mHead = new Node(item);
            mHead.next = oldHead;
            
            // Linking
            oldHead.previous = mHead;
        }
        mCurrentSize++;
    }
    
    /**
     * Add the item to the end
     */
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (mTail == null) {
            mTail = new Node(item);
            mHead = mTail;
        } 
        else {
            Node oldTail = mTail;
            mTail = new Node(item);
            
            // Linking
            oldTail.next = mTail;
            mTail.previous = oldTail;
        }
        mCurrentSize++;
    }
    
    /**
     * Remove and return the item from the front
     */
    public Item removeFirst() {
        if (mHead == null) {
            throw new NoSuchElementException("Underflow");
        }
        Item itemToReturn = mHead.item;
        mHead = mHead.next;
        mCurrentSize--;
        if (isEmpty()) {
            mTail = null;
            mHead = null;
        }
        return itemToReturn;
    }
    
    /**
     * Remove and return the item from the end
     */
    public Item removeLast() {
        if (mTail == null) {
            throw new NoSuchElementException("Underflow");
        }
        Item itemToReturn = mTail.item;
        mTail = mTail.previous;
        mCurrentSize--;
        return itemToReturn;
    }
    
    /**
     * Return an iterator over items in order from front to end
     */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    
    private class ListIterator implements Iterator<Item> {
        private Node walk = mHead;
        public boolean hasNext() {
            return walk != null;
        }
        
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item itemToReturn = walk.item;
            walk = walk.next;
            return itemToReturn;
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}