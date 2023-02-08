package SortingArrays.Assignments;

public class InsertionSortingDescendingOrder {
    public static void main(String[] args) {
        int[] arr= {3,6,2,1,8,7,4,5,3,1};
        for (int i = 1; i < arr.length; i++) {
            int current_element = arr[i];
            int prev = i-1;
            while(prev>=0 && arr[prev]<current_element){
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = current_element;
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
