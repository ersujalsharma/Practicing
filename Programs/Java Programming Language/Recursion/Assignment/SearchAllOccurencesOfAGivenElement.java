package Recursion.Assignment;

public class SearchAllOccurencesOfAGivenElement {
    public static void main(String[] args) {
        int arr[] = {3,2,4,5,6,2,7,2,2};
        fun(arr,0,2);
    }

    private static void fun(int[] arr, int i, int key) {
        if(i==arr.length){
            return;
        }
        if(arr[i] == key){
            System.out.print(i+" ");
        }
        fun(arr, i+1, key);
    }
}
