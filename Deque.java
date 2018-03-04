import java.lang.UnsupportedOperationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
   private Node mHead;
   private Node mTail;
    
   private class Node {
       Item item;
       Node next;
       Node previous;
       public Node(Item item) {
           this.item = item;
           this.next = null;
           this.previous = null;
       }
   }
    
   /**
    * Construct an empty deque
    */
   public Deque(){
   }
   
   /**
    * is the deque empty?
    */
   public boolean isEmpty(){
       return mHead == null;
   }
   
   /**
    * Return the number of items on the deque
    */
   public int size(){
       int count = 0;
       Node current = mHead;
       while(iterator().hasNext()){
           ++count;
       }
       
       return count;
   }
   
   /**
    * Add the item to the front
    */
   public void addFirst(Item item){
       if (item == null) {
           throw new IllegalArgumentException();
       }
       if (mTail == null) {
           mHead = new Node(item);
           //mHead.item = item;
           //mHead.next = mHead.previous = null;
           mTail = mHead;
       } else {
           Node oldHead = mHead;
           mHead = new Node(item);
           //mHead.item = item;
           mHead.next = oldHead;
           
           // Linking
           //mHead.previous = null;
           oldHead.previous = mHead;
       }
   }
   
   /**
    * Add the item to the end
    */
   public void addLast(Item item){
       if (item == null) {
           throw new IllegalArgumentException();
       }
       if (mTail == null) {
           mTail = new Node(item);
           //mTail.item = item;
           //mTail.next = mTail.previous = null;
           mHead = mTail;
       } else {
           Node oldTail = mTail;
           mTail = new Node(item);
           //mTail.item = item;
           //mTail.next = null;
           
           // Linking
           oldTail.next = mTail;
           mTail.previous = oldTail;
       }
   }
   
   /**
    * Remove and return the item from the front
    */
   public Item removeFirst(){
       if (mHead == null) {
           throw new NoSuchElementException("Underflow");
       }
       Item itemToReturn = mHead.item;
       mHead = mHead.next;
       return itemToReturn;
   }
   
   /**
    * Remove and return the item from the end
    */
   public Item removeLast(){
       if (mTail == null) {
           throw new NoSuchElementException("Underflow");
       }
       Item itemToReturn = mTail.item;
       mTail = mTail.previous;
       return itemToReturn;
   }
   
   /**
    * Return an iterator over items in order from front to end
    */
   public Iterator<Item> iterator(){
       return new ListIterator();
   }
   
   private class ListIterator implements Iterator<Item> {
       Node walk = mHead;
       public boolean hasNext() {
           return walk != null;
       }
       
       public Item next() {
           if(!hasNext()) {
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