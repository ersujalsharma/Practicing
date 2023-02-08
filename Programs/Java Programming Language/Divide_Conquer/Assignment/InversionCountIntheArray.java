package Divide_Conquer.Assignment;

public class InversionCountIntheArray {
    public static void main(String[] args) {
        int arr[] = {2,4,1,3,5};
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]>arr[j]&&i<j){
                    count++;
                }
            }
        }
        System.out.println(count);
        int ans = mergeSort(arr);
        System.out.println(ans);
    }

    private static int mergeSort(int[] arr) {
        
        return 0;
    }
}
