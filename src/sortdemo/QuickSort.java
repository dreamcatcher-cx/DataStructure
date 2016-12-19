package sortdemo;

/**
 * Created by chengxiao on 2016/12/14.
 * 快速排序
 */
public class QuickSort {
    public static void main(String []args){
        int []arr = new int[10000000];
        //System.out.println((int)(Math.random()*100000));
        for(int i=0;i<10000000;i++){
            arr[i] = (int)(Math.random()*10000000);
        }
       // int arr[] = {10,9,8,7,6,5,4,3,2,1};
        long start = System.currentTimeMillis();
        quickSort(arr,0,arr.length-1);
        //System.out.println(Arrays.toString(arr));

        long end = System.currentTimeMillis();
        System.out.println("排序完成,共计耗时"+(end-start)+"毫秒");
//        int []arr = {9,8,7,6,5,4,3,2,1};
//        quickSort(arr,0,arr.length-1);
       // System.out.println(Arrays.toString(arr));
    }

    /**
     *
     * @param arr
     * @param left 左指针
     * @param right 右指针
     */
    public static void quickSort(int []arr,int left,int right){
        if(left < right){
            //获取枢纽值，并将其放在当前待处理序列末尾
            dealPivot(arr,left,right);
            //枢纽值被放在序列末尾
            int pivot = right-1;
            //左指针
            int lPos = left;
            //右指针
            int rPos = right-1;
            while(true) {
                while (arr[++lPos] < arr[pivot] ){
                }
                while (rPos>left && arr[--rPos] > arr[pivot]) {
                }
                if (lPos < rPos) {
                    swap(arr, lPos, rPos);
                } else {
                    break;
                }
            }
            if(lPos<right){
                swap(arr,lPos,right-1);
            }
            quickSort(arr,left,lPos-1);
            quickSort(arr,lPos+1,right);
        }

    }

    /**
     * 处理枢纽值
     * @param arr
     * @param left
     * @param right
     */
    public static void dealPivot(int []arr,int left,int right){
        int mid = (left+right)/2;
        if(arr[left] > arr[mid]){
            swap(arr,left,mid);
        }
        if(arr[left] > arr[right]){
            swap(arr,left,right);
        }
        if(arr[right] < arr[mid]){
            swap(arr,right,mid);
        }
        swap(arr,right-1,mid);
    }
    /**
     * 交换元素通用处理
     * @param arr
     * @param a
     * @param b
     */
    private static void swap(int []arr,int a,int b){
        if(a>=0 && b>=0) {
           int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }
}
