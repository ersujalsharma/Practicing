package Divide_Conquer;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {6,3,9,8,2,5};
        quickSort(arr,0,arr.length-1);
        for (int i : arr) {
            System.out.println(i+" ");
        }
    }

    private static void quickSort(int[] arr, int i, int j) {
        if(i>j) return;
        int pivot_index = partition(arr,i,j);
        quickSort(arr, i, pivot_index-1);
        quickSort(arr, pivot_index+1, j);
    }

    private static int partition(int[] arr, int start_index, int end_index) {
        int pivot = arr[end_index];
        int i = start_index-1;
        int j=start_index;
        while(j<end_index){
            if(arr[j]<=pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
            j++;
        }
        i++;
        int temp = pivot;
        arr[end_index] = arr[i];
        arr[i] = temp;
        return i;
    }
}
