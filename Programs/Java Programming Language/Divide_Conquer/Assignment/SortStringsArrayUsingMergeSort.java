package Divide_Conquer.Assignment;

public class SortStringsArrayUsingMergeSort {
    public static void main(String[] args) {
        String[] arr = {"sun","earth","mars","mercury"};
        mergeSort(arr,0,arr.length-1);
        for (String string : arr) {
            System.out.println(string);
        }
    }

    private static void mergeSort(String[] arr, int start, int end) {
        if(start == end) return;
        int mid =(start+end)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, start,mid,end);
    }

    private static void merge(String[] arr, int start, int mid, int end) {
        String[] auxArray = new String[end-start+1];
        int i =start;
        int j = mid+1;
        int k = 0;
        while(i<=mid && j<=end){
            if(arr[i].compareTo(arr[j])<0){
                auxArray[k++] = arr[i++];
            }
            else{
                auxArray[k++] = arr[j++];
            }
        }
        while(i<=mid){
            auxArray[k++] = arr[i++];
        }
        while(j<=end){
            auxArray[k++] = arr[j++];
        }
        for (int k2 = 0, l = start; k2 < auxArray.length;l++, k2++) {
            arr[l] = auxArray[k2];
        }
    }
}
