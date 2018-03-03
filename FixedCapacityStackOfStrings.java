/**
 * Array Based Stack with limitation thats its of a constant size
 */
public class FixedCapacityStackOfStrings {
    private String[] mStack;
    private int mTop;
    
    public FixedCapacityStackOfStrings(int size) {
        mStack = new String[size];
    }
    
    public void push(String stringToPush) {
        mStack[mTop++] = stringToPush;
    }
    
    /**
     * The below strategy to set the value to null helps as it prevents loitering.
     * Setting value to null helps garbage collector to reclaim memory.
     * 
     * Underflow check not implemented
     */
    public String pop() {
        String value = mStack[--mTop];
        mStack[mTop] = null;
        return value;
    }
    
    public boolean isEmpty() {
        return mStack == null;
    }
}
