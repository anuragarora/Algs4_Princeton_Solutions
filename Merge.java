public class Merge {
    public static void sort (Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort (a, aux, 0, a.length - 1);
    }
    
    private static void sort (Comparable[] a, Comparable[] aux, 
                             int low, int high) {
        // Merging the two arrays by comparison // edge case
        if (high <= low) {
            return;
        }
        
        // Finding mid
        int mid = (low + high) / 2;
        
        // Sorting left half
        sort(a, aux, low, mid);
        
        // Sorting the right half
        sort(a, aux, mid + 1, high);
        
        // Merging the two arrays
        merge(a, aux, low, mid, high);
    }
    
    private static void merge (Comparable[] a, Comparable[] aux, 
                         int low, int mid, int high) {
        // Assert that the left subArray is sorted
        assert isSorted(a, low, mid);
        // Assert that the right subArray is sorted
        assert isSorted(a, mid + 1, high);
        
        // Copying the array to auxillary array, not creating aux in recursive 
        // subroutine as it adds to additional complexity.
        for (int i = low; i <= high; i++) {
            aux[i] = a[i];
        }
        
        int i = 0;
        int j = mid + 1;
        for (int k = 0; k <= high; k++) {
            // If the first subArray is exhausted, copy 2nd subArray to merged Array
            if (i > mid) {
                a[k] = aux[j++];
            }
            // If the second subArray is exhausted, copy the 1st subArray to merged Array
            else if (j > high) {
                a[k] = aux[i++];
            }
            // If the element of the first subArray is less than the item of the second SubArray
            else if (less(aux[i], aux[j])) {
                a[k] = aux[i++];
            }
            // If the element of the second subArray is less than the item of the first SubArray
            else {
                a[k] = aux[j++];
            }
        }
        
        // Assert that the final merged subArray is sorted
        assert isSorted(a, low, high);
    }
    
    private static boolean less(Comparable x, Comparable y) {
        if (x == null || y == null) {
            throw new IllegalArgumentException("Comparable objects cannot be null");
        }
        return x.compareTo(y) < 0;
    }
    
    private static boolean isSorted(Comparable[] a, int low, int high) {
        for (int index = low+1; index <= high; index++) {
            if (less(a[index], a[index - 1])) {
                return false;
            }
        }
        return true;
    }
}