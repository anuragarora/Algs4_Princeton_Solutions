import edu.princeton.cs.algs4.StdRandom;

public class Random {
    public static void shuffle(Object[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int toShuffle = StdRandom.uniform(i + 1);
            exchange (a, i, toShuffle);
        }
    }
    
    public static void exchange (Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}