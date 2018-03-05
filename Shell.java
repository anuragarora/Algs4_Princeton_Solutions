public class Shell {
    public static void sort (Comparable[] a) {
        int n = a.length;
        int h = 1;
        
        // This is for 3x+1 increments - 1, 4, 13, 121, 364
        while (h < n/3) {
            h = h*3 + 1;
        }
        
        while (h >= 1) {
            for (int i = h; i < n; i += h) {
                for (int j = i; j >= h; j -= h) {
                    if (less(a[j], a[j-h])) {
                        exchange(a, j, j-h);
                    }
                }
            }
            h /= 3;
        }
    }
    
    private static boolean less (Comparable x, Comparable y) {
        if (x == null || y == null) {
            throw new IllegalArgumentException ("Comparable objects can't be null");
        }
        return x.compareTo(y) < 0;
    }
    
    private static void exchange(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}