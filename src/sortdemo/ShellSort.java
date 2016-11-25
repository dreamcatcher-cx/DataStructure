package sortdemo;

import java.util.Arrays;

/**
 * Created by chengxiao on 2016/11/24.
 */
public class ShellSort {
    public static void main(String []args){
        int []arr ={1,4,2,7,9,8,3,6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

//    /**
//     * 希尔排序
//     * @param arr
//     */
//    public static void sort(int []arr){
//        int gap = arr.length/2;
//        while(gap>1){
//            for(int i=0;i<gap;i++){
//                for(int j=gap+i;j<arr.length;j+=gap){
//                    int k=j;
//                    if(arr[k]<arr[k-gap]){
//                        while(k-gap>=0 && arr[k]<arr[k-gap]){
//                            arr[k] = arr[k]+arr[k-gap];
//                            arr[k-gap] = arr[k]-arr[k-gap];
//                            arr[k] = arr[k]-arr[k-gap];
//                            k-=gap;
//                        }
//                    }
//                }
//            }
//            gap/=2;
//        }
//    }

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
}
