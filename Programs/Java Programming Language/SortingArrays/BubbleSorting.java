package SortingArrays;

public class BubbleSorting {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        // Bubble Sorting :- Largest Element come to the end
        for (int turn = 0; turn < arr.length-1; turn++) {
            int swap =0;
            for (int j = 0; j < arr.length-1-turn; j++) {
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    swap++;
                }
            }
            if(swap ==0){
                break;
            }
        }
        printArr(arr);
    }
    public static void printArr(int[] arr){
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
