package SortingArrays;

public class SelectionSort {
    // pick the smallest (from unsorted) and put it at the begining.
    public static void main(String[] args) {
        int arr[] = {5,4,1,3,2};
        selectionsortsujal(arr);
    }

    private static void selectionsortsujal(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int minElementPos = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]<arr[minElementPos]){
                    minElementPos = j;
                }
            }
            int temp = arr[minElementPos];
            arr[minElementPos] = arr[i];
            arr[i] = temp;
        }
        BubbleSorting.printArr(arr);
    }
}
