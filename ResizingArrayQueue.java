import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayQueue<T> implements Iterable<T>{
    private T[] mQueue;
    private int mHead, mTail, mCurrentSize, mSize;
    
    public Iterator<T> iterator() {
        return new QueueIterator();
    }
    
    public ResizingArrayQueue() { 
        mQueue = (T[]) new Object[1];
        mHead = 0;
        mSize = 1;
        mTail = mSize - 1;
        mCurrentSize = 0;
    }
    
    public void enQueue(T valueToEnque){
        if (mCurrentSize == mSize) {
            resize(2 * mSize);
        }
        mTail = ++mTail % mSize;
        mQueue[mTail] = valueToEnque;
        mCurrentSize++;
    }
    
    public T deQueue(){
        if(mCurrentSize == mSize / 4) {
            resize(mSize / 2);
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
    
    public void resize(int size){
        T[] newQueue = (T[]) new Object[size];
        int mCurrent = 0;
        while(mCurrent < mCurrentSize){
            newQueue[mCurrent] = mQueue[(mCurrent + mHead) % mSize];
            mCurrent++;
        }
        
        mQueue = newQueue;
        mSize = size;
        mHead = 0;
        mTail = mCurrentSize - 1; 
    }
    
    private class QueueIterator implements Iterator<T> {
        private int mCurrent = 0;
        
        public boolean hasNext() {
            return mCurrent < mCurrentSize;
        }
        
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T valueToReturn = mQueue[(mCurrent + mHead) % mSize];
            mCurrent++;
            return valueToReturn;
        }
        
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }
}