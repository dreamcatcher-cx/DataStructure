package sortdemo;

/**
 * Created by chengxiao on 2016/11/22.
 */
public class SimpleSort {
    public static void main(String[] args) {
        //int[] arr = {12, 43, 10, 9, 23, 75, 18, 3, 14, 56, 34, 29};
        //int []arr = {10,9,8,7,6,5,4,3,2,1,0};
//        bubbleSort(arr);
//        System.out.println("冒泡排序后：" + Arrays.toString(arr));
        //增强型冒泡排序
//        enhanceBubbleSort(arr);
//        System.out.println("增强型冒泡排序：" + Arrays.toString(arr));
        //简单选择排序
//        selectSort(arr);
//        System.out.println("简单选择排序："+ Arrays.toString(arr));
        //简单插入排序
//        insertionSort(arr);
//        System.out.println("简单插入排序:" + Arrays.toString(arr));
        int []arr = new int[10000000];
        //System.out.println((int)(Math.random()*100000));
        for(int i=0;i<10000000;i++){
            arr[i] = (int)(Math.random()*10000000);
        }
        long start = System.currentTimeMillis();
        bubbleSort(arr);
        //System.out.println(Arrays.toString(arr));

        long end = System.currentTimeMillis();
        System.out.println("排序完成,共计耗时"+(end-start)+"毫秒");
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort1(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j] + arr[j + 1];
                    arr[j + 1] = arr[j] - arr[j + 1];
                    arr[j] = arr[j] - arr[j + 1];
                }
            }
        }
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;//设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已然完成。
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr,j,j+1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }
    /**
     * 简单选择排序
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;//每一趟循环比较时，设置min变量，用于存放较小元素的数组下标，这样当前批次比较完毕最终存放的就是此趟内最小的元素的下标，避免每次遇到较小元素都要进行交换。
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            //进行交换，如果min发生变化，则进行交换
            if (min != i) {
                swap(arr,min,i);
            }
        }
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                swap(arr,j,j-1);
                j--;
            }
        }
    }

    /**
     * 交换数组元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a,int b){
        arr[a] = arr[a]+arr[b];
        arr[b] = arr[a]-arr[b];
        arr[a] = arr[a]-arr[b];
    }
}
