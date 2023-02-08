package Divide_Conquer;

public class SearchInARotatedSortedArray {
    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2};
        
        int key = 0;
        /*
        int min_index = findminElementIndex(arr);
        int index=-1;
        if(arr[0]<=key && arr[min_index-1]>=key){
            index = search(arr, 0, min_index-1, key);
        }
        else{
            index = search(arr, min_index, arr.length-1, key);
        }
        System.out.println(index);
        */
        int index = fun(arr,0,arr.length-1,key);
        System.out.println(index);
    }
/* 
    private static int search(int[] arr, int i, int j, int key) {
       while(i<=j){
        int mid = (i+j)/2;
        if(arr[mid] == key){
            return mid;
        }
        else if(arr[mid]<key){
            i = mid+1;
        }
        else{
            j = mid-1;
        }
       }
       return -1;
    }

    private static int findminElementIndex(int[] arr) {
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for (int i=0;i<arr.length;i++) {
            if(arr[i]<min){
                min = arr[i];
                min_index = i; 
            }
        }
        return min_index;
    }
    */

    private static int fun(int[] arr, int start_index, int end_index,int key) {
        if(start_index>end_index){
            return -1;
        }
        int mid = (start_index+end_index)/2;
        if(arr[mid] == key ){
            return mid;
        }
        if(arr[start_index] <= arr[mid]){ // line 1
            if(arr[start_index]<=key && key<=arr[mid]){
                return fun(arr, start_index, mid-1, key);
            }
            else{
                return fun(arr, mid+1, end_index, key);
            }
        }
        else{ // line 2
            if(arr[mid]<=key && key<arr[end_index]){
                return fun(arr, mid+1, end_index, key);
            }
            else{
                return fun(arr, start_index, mid-1, key);
            }
        }
    }
}
