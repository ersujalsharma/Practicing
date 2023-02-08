package Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10,12,14};
        int key = 13;
        int ans = binarySearch(arr,key);
        System.out.println(ans);
    }

    private static int binarySearch(int[] arr, int key) {
        int start =0;
        int end= arr.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid] == key){
                return mid;
            }
            else if(arr[mid]<key){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }
}
