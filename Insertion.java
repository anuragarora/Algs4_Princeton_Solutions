public class Insertion {
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j-1])) {
                    exchange(a, j, j-1);
                }
                else break;
            }
        }
    }
    
    private static boolean less(Comparable x, Comparable y) {
        if (x == null || y == null) {
            throw new IllegalArgumentException("Items to be compared cannot be null");
        }
        return x.compareTo(y) < 0;
    }
    
    private static void exchange(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}