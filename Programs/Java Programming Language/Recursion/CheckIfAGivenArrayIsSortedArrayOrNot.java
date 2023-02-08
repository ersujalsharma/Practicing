package Recursion;

public class CheckIfAGivenArrayIsSortedArrayOrNot {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        System.out.println(isSortedOrNot(arr,0));
    }

    private static boolean isSortedOrNot(int[] arr, int i) {
        if(i==arr.length-1)
            return true;
        if(arr[i]>arr[i+1]){
            return false;
        }
        return isSortedOrNot(arr, i+1);
    }
}
