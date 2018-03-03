public class ResizingArrayStackOfStrings{
    private String[] mStack;
    private int mTop;
    
    public ResizingArrayStackOfStrings(){
        mStack = new String[1];
    }
    
    public void push(String stringToPush) {
        if (mStack.length == mTop + 1) {
            resize(mStack.length * 2);
        }
        mStack[mTop++] = stringToPush;
    }
    
    /**
     * Underflow check not implemented
     */
    public String pop() {
        String value = mStack[--mTop];
        if(mTop > 0 && mStack.length == (mTop + 1) / 4) {
            resize(mStack.length / 2);
        }
        mStack[mTop] = null;
        return value;
    }
    
    private void resize(int size) {
        String[] newStack = new String[size];
        for (int index = 0; index <= mTop; index++){
            newStack[index] = mStack[index];
        }
        mStack = newStack;
    }
    
    public boolean isEmpty() {
        return mStack == null;
    }
}