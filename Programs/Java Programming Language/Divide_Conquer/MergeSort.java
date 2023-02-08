package Divide_Conquer;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {6,3,9,5,2,8};
        int start_index = 0;
        int end_index = arr.length-1;
        MergeSort(arr,start_index,end_index);
        for (int i : arr) {
            System.out.println(i);
        }
    }
    private static void MergeSort(int[] arr, int start_index, int end_index) {

        if(start_index>end_index || start_index == end_index){
            return;
        }
        int mid = start_index+(end_index-start_index)/2;
        MergeSort(arr, start_index, mid);
        MergeSort(arr, mid+1, end_index);
        mergeTwoSortedArrays(arr,start_index,mid,end_index);
    }

    private static void mergeTwoSortedArrays(int[] arr, int start_index, int mid, int end_index) {
        int tempArr[] = new int[end_index-start_index+1];
        int i=start_index;
        int j = mid+1;
        int k=0;
        while (i<=mid&&j<=end_index) {
            if(arr[i]<arr[j]){
                tempArr[k++] = arr[i++];
            }
            else{
                tempArr[k++] = arr[j++];
            }
        }
        while(i<=mid){
            tempArr[k++] = arr[i++];
        }
        while(j<=end_index){
            tempArr[k++] = arr[j++];
        }
        for (int k2 = 0, l= start_index; k2 < tempArr.length; l++,k2++) {
            arr[l] = tempArr[k2];
        }
    }
}
