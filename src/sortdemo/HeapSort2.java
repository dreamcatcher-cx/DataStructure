package sortdemo;

import java.util.Arrays;

/**
 * Created by chengxiao on 2016/11/30.
 */
public class HeapSort2 {
    public static void main(String []args){
       int []arr = {9,9,9,9,9,9,9};
        HeapSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 构建大顶堆
     * @param arr 数组
     * @param number  层序编号
     * @param length  待排序列长度
     */
    public static void buildHeap(int[] arr,int number,int length){
        int temp = arr[number-1];
        for(int i=number*2;i<=length;i*=2){
            if(i<length && arr[i-1]<arr[i]){
                i++;
            }
            if(arr[i-1]>temp){
                arr[number-1] = arr[i-1];
                number = i;
            }
        }
        arr[number-1] = temp;
    }
    public static void HeapSort(int []arr){
        //初始化堆
        for(int i=arr.length/2;i>0;i--){
            buildHeap(arr,i,arr.length);
        }
        for(int j=arr.length;j>1;j--){
            buildHeap(arr,1,j);
            arr[0] = arr[0]+arr[j-1];
            arr[j-1] = arr[0]-arr[j-1];
            arr[0] = arr[0]-arr[j-1];
        }
    }
}
