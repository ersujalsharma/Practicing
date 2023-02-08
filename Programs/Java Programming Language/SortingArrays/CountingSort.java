package SortingArrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {1,4,1,3,2,4,7};
        // first create an auxillary array 
        int largest =  Integer.MIN_VALUE;
        for (int i : arr) {
            largest = Math.max(largest, i);
        }
        int[] auxArray = new int[largest+1];
        for (int i : arr) {
            auxArray[i]++; 
        }
        for (int i : auxArray) {
            System.out.print(i+" ");
        }
        int j = 0;
        for (int i = 0; i < auxArray.length; i++) {
            while(auxArray[i]>0){
                arr[j] = i;
                j++;
                auxArray[i]--;
            }
        }
        BubbleSorting.printArr(arr);
    }
}
