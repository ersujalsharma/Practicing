package BackTracking;

public class FillAndDecreaseTheArray {
    public static void main(String[] args) {
        int arr[] = new int[5];
        FillAndDecreaseTheArray(arr,0);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void FillAndDecreaseTheArray(int[] arr,int index) {
        if(index == arr.length){
            return;
        }
        arr[index] = index+1;
        FillAndDecreaseTheArray(arr, index+1);
        arr[index] -=2;
    }

}
