package LinkedList;

/**
 * MergeSortOnALinkedlIst
 */
public class MergeSort{

    public static void main(String[] args) {
        //
        int[] arr = {4,2,7,3,8,6,1,5};
        mergeSort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"|");
        }
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if(start>end || start == end){
            return;
        }
        int mid = start+(end-start)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        mergeSortedArray(arr,start,mid,end);
    }

    private static void mergeSortedArray(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid+1;
        int k = 0;
        int temp[] = new int[end-start+1]; 
        while(i<=mid && j<=end){
            if(arr[i]<arr[j]){
                temp[k++] = arr[i++];
            }
            else{
                temp[k++] = arr[j++];
            }
        }
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        while(j<=end){
            temp[k++] = arr[j++];
        }
        for (int l = 0,m=start ; l < temp.length;m++, l++) {
            arr[m] = temp[l];
        }
    }
}