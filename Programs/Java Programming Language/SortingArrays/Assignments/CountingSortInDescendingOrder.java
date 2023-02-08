package SortingArrays.Assignments;

public class CountingSortInDescendingOrder {
    public static void main(String[] args) {
        int[] arr= {3,6,2,1,8,7,4,5,3,1};
        int[] auxarr = new int[arr.length+1];
        for (int i : arr) {
            auxarr[i]++;
        }
        for (int i : auxarr) {
            System.out.println(i);
        }
        int j=arr.length-1;
        for (int i = 1; i < auxarr.length; i++) {
            while (auxarr[i]!=0) {
                arr[j--] = i;
                auxarr[i]--;
            }
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
