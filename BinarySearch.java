public class BinarySearch{
    public int search(int array[], int key){
        int low = 0, high = array.length-1;

        while (low <= high) {  
            int mid = (low + high) / 2;
            if (key > array[mid]) {
                low = mid + 1;
            } else if (key < array[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        
        return -1;
    }
    
    public static void main(String args[]) {
        BinarySearch bs = new BinarySearch();
        int array[] = {1, 2, 3, 67, 102, 334, 567, 729, 900};
        System.out.println(bs.search(array, 1000));
    }
}