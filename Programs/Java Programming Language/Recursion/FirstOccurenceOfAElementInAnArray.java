package Recursion;

public class FirstOccurenceOfAElementInAnArray {
    public static void main(String[] args) {
        int arr[] = {1,2,3,2,5};
        int index = firstOccurenceOfAElementInAnArray(arr,0,2);
        System.out.println(index);
    }

    private static int firstOccurenceOfAElementInAnArray(int[] arr, int i, int item) {
        if(i == arr.length) return -1;
        if(arr[i] == item ) return i;
        return firstOccurenceOfAElementInAnArray(arr, i+1, item);
    }
}
