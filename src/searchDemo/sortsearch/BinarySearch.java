package searchDemo.sortsearch;

/**
 * Created by chengxiao on 2016/11/9.
 */
public class BinarySearch {
    public static void main(String[] args) throws Exception {
        int[] arr = {1, 12, 34, 56, 78, 98, 102};
        //search(arr,34,0,6);
        System.out.println(search(arr, 98));
    }

    public static int search(int[] arr, int key) {
        int begin = 0;
        int end = arr.length;
        while (begin <= end) {
            int mid = arr[(begin + end) / 2];
            if (key == mid) {
                return mid;
            } else if (key > mid) {
                begin++;
            } else if (key < mid) {
                end--;
            }
        }
        return 0;
    }
}
