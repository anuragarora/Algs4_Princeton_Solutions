import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private int mTrials;
    private double[] openCountArray; 
    
    // perform trials independent experiments on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n < 1 || trials < 1) {
            throw new IllegalArgumentException("n, trials cannot be < 1");
        }
        mTrials = trials;
        
        openCountArray = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation per  = new Percolation(n);
            
            while (!per.percolates()) {
                int randomRow = StdRandom.uniform(1, n + 1);
                int randomCol = StdRandom.uniform(1, n + 1);
                /* Check if random block is not already open, if this check is
                 not done the number of open site count would be wrongly calculated */
                if (!per.isOpen(randomRow, randomCol)) {
                    per.open(randomRow, randomCol);
                    if (per.percolates()) {
                        openCountArray[i] = per.numberOfOpenSites() / (n * n);
                        break;
                    }
                }
            } 
        }
    }
    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(openCountArray);
    }
    
    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(openCountArray);
    }
    
    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
        return (mean() - ((1.96 * stddev()) / Math.sqrt(mTrials)));
    }
    
    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return (mean() + ((1.96 * stddev()) / Math.sqrt(mTrials)));
    }
    
    // test client (described below)
    public static void main(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("please pass n and trials");
        }
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        PercolationStats pStat = new PercolationStats(n, trials);
        
        System.out.println("mean: " + pStat.mean());
        System.out.println("stdDev: " + pStat.stddev());
        System.out.println("95% confidence interval: [" + pStat.confidenceHi() + 
                           "," + pStat.confidenceLo() + "]");
    }
}