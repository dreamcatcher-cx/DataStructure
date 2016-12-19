package sortdemo;

/**
 * Created by chengxiao on 2016/12/16.
 */
public class QuickSort1 {
    public static void main(String[] args) {

    }

//    public static void QsortMedianOfThree(int[] arr, int low, int high) {
//        if (low >= high) return;                        //递归出口
//        PartitionMedianOfThree(arr, low, high);         //三数取中
//        int partition = Partition(arr, low, high);      //将 >= x 的元素交换到右边区域，将 <= x 的元素交换到左边区域
//        QsortMedianOfThree(arr, low, partition - 1);
//        QsortMedianOfThree(arr, partition + 1, high);
//    }
}
//    /// <summary>
//    /// 三数取中确定基准元，将确定好的基准元与第一个数交换，无返回值
//    /// </summary>
//    public static void PartitionMedianOfThree(int[] arr, int low, int high) {
//        int mid = low + (high + -low) / 2;
//        if (arr[mid] > arr[high]) {
//            Swap(arr, mid, high);
//        }
//        if (arr[low] > arr[high]) {
//            Swap(arr, low, high);
//        }
//        if (arr[mid] > arr[low]) {
//            Swap(arr, mid, low);
//        }
//        }
//    }
