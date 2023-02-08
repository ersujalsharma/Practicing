package Recursion;

public class LastOccurenceOfAElementInAnArray {
    public static void main(String[] args) {
        int arr[] = {8,3,6,9,5,3,10,2,5,3};
        int ans = lastOccurenceOfAElementInAnArray(arr,0,5,-1);
        int ans2 = lastOccurence(arr,0,5);
        System.out.println(ans2);
        System.out.println(ans);
    }

    private static int lastOccurence(int[] arr, int i, int key ){
        if(arr.length == i) return -1;
        int isFound = lastOccurence(arr, i+1, key);
        if(isFound!=-1){
            return isFound;
        }
        if(arr[i] == key){
            return i;
        }
        return -1;
    }

    private static int lastOccurenceOfAElementInAnArray(int[] arr, int i, int key, int index) {
        if(arr.length==i) return index;
        if(arr[i] == key) index = i;
        return lastOccurenceOfAElementInAnArray(arr, i+1, key, index);
    }
}
