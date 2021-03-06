import java.util.Comparator;

public class Merge {
    public static void sort (Point[] a, Comparator comparator) {
        Point[] aux = new Point[a.length];
        sort (a, aux, comparator, 0, a.length - 1);
    }
    
    private static void sort (Point[] a, Point[] aux, 
                             Comparator comparator, int low, int high) {
        // Merging the two arrays by comparison // edge case
        if (high <= low) {
            return;
        }
        
        // Finding mid
        int mid = (low + high) / 2;
        
        // Sorting left half
        sort(a, aux, comparator, low, mid);
        
        // Sorting the right half
        sort(a, aux, comparator, mid + 1, high);
        
        // Merging the two arrays
        merge(a, aux, comparator, low, mid, high);
    }
    
    private static void merge (Point[] a, Point[] aux, Comparator comparator,
                         int low, int mid, int high) {
        // Assert that the left subArray is sorted
        assert isSorted(comparator, a, low, mid);
        // Assert that the right subArray is sorted
        assert isSorted(comparator, a, mid + 1, high);
        
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
            else if (less(comparator, aux[j], aux[i])) {
                a[k] = aux[j++];
            }
            // If the element of the second subArray is less than the item of the first SubArray
            else {
                a[k] = aux[i++];
            }
        }
        
        // Assert that the final merged array is sorted
        assert isSorted(comparator, a, low, high);
    }
    
    private static boolean less(Comparator comparator, Point x, Point y) {
        if (x == null || y == null) {
            throw new IllegalArgumentException("instances cannot be null");
        }
        return comparator.compare(x, y) < 0;
    }
    
    private static boolean isSorted(Comparator comparator, Point[] a, int low, int high) {
        for (int index = low+1; index <= high; index++) {
            if (less(comparator, a[index], a[index - 1])) {
                return false;
            }
        }
        return true;
    }
}