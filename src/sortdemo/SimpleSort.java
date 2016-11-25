package sortdemo;

import java.util.Arrays;

/**
 * Created by chengxiao on 2016/11/22.
 */
public class SimpleSort {
    public static void main(String[] args) {
        int[] arr = {12, 43, 10, 9, 23, 75, 18, 3, 14, 56, 34, 29};
        //int []arr = {5,1,2,3,4};
        //bubbleSort(arr);
        //System.out.println("冒泡排序后：" + Arrays.toString(arr));
        //增强型冒泡排序
//        enhanceBubbleSort(arr);
//        System.out.println("增强型冒泡排序：" + Arrays.toString(arr));
        //简单选择排序
//        selectionSort(arr);
//        System.out.println("简单选择排序："+ Arrays.toString(arr));
        //简单插入排序
        insertionSort(arr);
        System.out.println("简单插入排序:"+ Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
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
     * 增强型冒泡排序，避免不必要的比较
     *
     * @param arr
     */
    public static void enhanceBubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j] + arr[j + 1];
                    arr[j + 1] = arr[j] - arr[j + 1];
                    arr[j] = arr[j] - arr[j + 1];
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
     * @param arr
     */
    public static void selectionSort(int[] arr){
        int min = 0;
        for(int i=0;i<arr.length-1;i++){
            min = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            if(min!=i){
                arr[i] = arr[i]+arr[min];
                arr[min] = arr[i]-arr[min];
                arr[i] = arr[i]-arr[min];
            }
        }
    }

    /**
     * 插入排序
     * @param arr
     */
    public static void insertionSort(int []arr){
        for(int i=1;i<arr.length;i++){
            int j=i;
            while(j>0 && arr[j]<arr[j-1]){
                arr[j] = arr[j]+arr[j-1];
                arr[j-1] = arr[j]-arr[j-1];
                arr[j] = arr[j]-arr[j-1];
                j--;
            }
        }
    }
}
