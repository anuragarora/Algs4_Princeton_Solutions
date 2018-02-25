import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int mSize;
    private boolean[][] mGrid;
    private int mTop;
    private int mBottom;
    private int mNumberOfOpenSites;
    private WeightedQuickUnionUF mWQUF;
    
    public Percolation(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n should be greater than 0");
        }
        
        this.mSize = n;
        // Adding a source above the grid we want to percolate
        mTop = 0;
        
        // Adding a sink below the grid we want to percolate
        this.mBottom = n * n + 1;
        
        // Initializing (default value of boolean primitive is false by default)
        mGrid = new boolean[n][n];
        
        // Number of open sites is 0 when initializing
        mNumberOfOpenSites = 0;
        
        // Initialising UF
        mWQUF = new WeightedQuickUnionUF(n * n + 2);
    }
    
    // Converts an index from 2D array to 1D
    private int getIndex(int row, int col) {
        if (row > mSize || col > mSize || row <= 0 || col <= 0) {
            throw new IllegalArgumentException("address out of grid");
        }
        return (row - 1) * mSize + col;
    }
    
    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        mGrid[row - 1][col - 1] = true;
        
        // If given row is the first row, union the source and the block
        if (row == 1) {
            mWQUF.union(mTop, getIndex(row, col));
        }
        
        // If given row is the last row, union the sink and the block
        if (row == mSize) {
            mWQUF.union(mBottom, getIndex(row, col));
        }
        
        // Union the left block if exists and is open
        if (row > 1 && isOpen(row - 1, col)) {
            mWQUF.union(getIndex(row, col), getIndex(row-1, col));
        }
        
        // Union the right block if it exists and is open
        if (row < mSize && isOpen(row + 1, col)) {
            mWQUF.union(getIndex(row, col), getIndex(row + 1, col));
        }
        
        // Union the top block if it exists and is open
        if (col > 1 && isOpen(row, col - 1)) {
            mWQUF.union(getIndex(row, col), getIndex(row, col - 1));
        }
        
        // Union the bottom block if it exists and is open
        if (col < mSize && isOpen(row, col + 1)) {
            mWQUF.union(getIndex(row, col), getIndex(row, col + 1));
        }
        
        // Incrementing the count of number of open sites by 1
        mNumberOfOpenSites += 1;
    }
    
    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        return mGrid[row - 1][col - 1];
    }
    
    // is site (row, col) full? Full means percolation is possible from 
    // top to this block
    public boolean isFull(int row, int col) {
        // A site is a full site if it can be connected from the mTop (source)
        if (mWQUF.connected(mTop, getIndex(row, col))) {
            return true;
        }
        return false;
    }
    
    // Keeps track of number of open sites
    public double numberOfOpenSites() {
        return (double)mNumberOfOpenSites;
    }
    
    // does the system percolate?
    // A site percolates if source is connected to sink
    public boolean percolates() {
        if (mWQUF.connected(mTop, mBottom)) {
            return true;
        }
        return false;
    }

    // test client (optional)
    public static void main(String[] args) {
       
    }
}