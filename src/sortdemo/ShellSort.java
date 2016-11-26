package sortdemo;

import java.util.Arrays;

/**
 * Created by chengxiao on 2016/11/24.
 */
public class ShellSort {
    public static void main(String []args){
        int []arr ={1,4,2,7,9,8,3,6};
        sort1(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 希尔排序
     * @param arr
     */
    public static void sort1(int []arr){
       for(int gap=arr.length/2;gap>0;gap/=2){
           for(int i=gap;i<arr.length;i++){
               int j = i;
               while(j-gap>=0 && arr[j]<arr[j-gap]){
                   swap(arr,j,j-gap);
                   j-=gap;
               }
           }
       }
    }

    /**
     * 希尔排序
     * @param arr
     */
    public static void sort(int []arr){
        int gap = arr.length/3+1;
        while(gap>0){
            //分为gap-1组,逐组进行简单插入排序
            for(int i=0;i<gap;i++){
                for(int j=gap+i;j<arr.length;j+=gap){
                    int k = j;
                    if(arr[k]<arr[k-gap]){
                        while(k-gap>=0  && arr[k]<arr[k-gap]){
                            arr[k] = arr[k]+arr[k-gap];
                            arr[k-gap] = arr[k] - arr[k-gap];
                            arr[k] = arr[k] - arr[k-gap];
                            k-=gap;
                        }
                    }
                }
            }
            gap/=2;
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
