public class BottomUpMerge {
    public static void sort (Comparable[] a) {
        int n = a.length;
        Comparable[] aux = new Comparable[n];
        
        // the outer loop is called logn times and the inner loop is called n times
        for (int size = 1; size < n; size = 2 * size) {
            for (int low = 0; low < n - size; low += 2 * size) {
                merge (a, aux, low, low + size - 1, 
                       Math.min (low + 2 * size - 1, n - 1));
            }
        }
    }
    
    private static void merge (Comparable[] a, Comparable[] aux, int low, int mid, int high) {
        // Assert the left subarray is sorted
        assert isSorted (a, low, mid);
        
        // Assert the right subarray is sorted
        assert isSorted (a, mid + 1, high);
        
        // Copying the array to aux
        for (int index = low; index <= high; index++) {
            aux[index] = a[index];
        }
        
        // Merging the arrays
        int i = 0; int j = mid + 1;
        for (int k = 0; k <= high; k++) {
            // If first subarray is exhausted
            if (i > mid) {
                a[k] = aux[j++];
            }
            // If the second subarry is exhausted
            else if (j > high) {
                a[k] = aux[i++];
            }
            else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } 
            else {
                a[k] = aux[i++];
            }
        }
        
        // Making sure the final subarray is sorted
        assert isSorted (a, low, high);
    }
    
    private static boolean isSorted (Comparable[] a, int i, int j){
        for (int index = i + 1; index <= j; i++){
            if(less(a[index], a[index-1])) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean less (Comparable x, Comparable y) {
        if (x == null || y == null) {
            throw new IllegalArgumentException("objects to be compared cannot be null");
        }
        return x.compareTo(y) < 0;
    }
}