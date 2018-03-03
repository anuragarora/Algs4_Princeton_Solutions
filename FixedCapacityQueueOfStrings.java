import java.util.Iterator;
import java.util.NoSuchElementException;

public class FixedCapacityQueueOfStrings<T> implements Iterable<T>{
    private T[] mQueue;
    private int mHead, mTail, mCurrentSize, mSize;
    
    public Iterator<T> iterator(){
        return new QueueIterator();
    }
    
    public FixedCapacityQueueOfStrings(int size) {
        if (size < 1){
            throw new IllegalArgumentException("size cannot be less than 1");
        }
        mQueue = (T[]) new Object[size];
        mHead = 0;
        mTail = mSize - 1;
        mCurrentSize = 0;
        this.mSize = size;
    }
    
    public void enQueue(T valueToEnque){
        if (mCurrentSize == mSize) {
            throw new IllegalStateException ("Queue is full");
        }
        mQueue[(++mTail) % mSize] = valueToEnque;
        mCurrentSize++;
    }
    
    public T deQueue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T value = mQueue[mHead % mSize];
        mQueue[mHead % mSize] = null;
        mHead++;
        mCurrentSize--;
        return value;
    }
    
    public boolean isEmpty() {
        return mCurrentSize == 0;
    }
    
    private class QueueIterator implements Iterator<T> {
        private int mCurrent = 0;
        
        public T next(){
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            T itemToReturn = mQueue[(mCurrent + mHead) % mSize];
            mCurrent++;
            return itemToReturn;
        }
        
        public boolean hasNext(){
            return mCurrent < mCurrentSize;
        }
        
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }
}