package SortingArrays.Assignments;

public class SelectionSortingInDecreasingOrder {
    public static void main(String[] args) {
        int[] arr= {3,6,2,1,8,7,4,5,3,1};
        for (int i = 0; i < arr.length-1; i++) {
            int maxIndex=i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]>arr[maxIndex]){
                    maxIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
