public class Selection {
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[i])) {
                    min = j;
                }
                exchange(a, i, min);
            }
        }
    }
    
    private static boolean less(Comparable v, Comparable w) {
        if (v == null || w == null) {
            throw new IllegalArgumentException("Incompatible types");
        }
        return v.compareTo(w) < 0;
    }
    
    private static void exchange(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}