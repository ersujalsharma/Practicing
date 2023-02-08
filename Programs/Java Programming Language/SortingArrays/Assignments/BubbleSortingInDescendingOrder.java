package SortingArrays.Assignments;

public class BubbleSortingInDescendingOrder {
    public static void main(String[] args) {
        int[] arr= {3,6,2,1,8,7,4,5,3,1};
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j]<arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }
    public static void swap(int[] a, int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
