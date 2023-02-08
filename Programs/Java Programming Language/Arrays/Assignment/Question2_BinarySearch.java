package Arrays.Assignment;

public class Question2_BinarySearch {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int target = 0;
        int min = minSearch(arr);
        int index =0;
        if(arr[min]<=target && target <=arr.length-1)
            index = binarySearchSujal(arr,min,arr.length-1,target);
        else{
            index = binarySearchSujal(arr,0,min, target);
        }
        System.out.println(index);
   }

    private static int binarySearchSujal(int[] arr,int left,int right, int target) {
        int low = left;
        int high = right;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid]<target){
                low = mid+1;
            }
            else if(arr[mid]>target){
                high = mid-1;
            }
        }
        return -1;
    }
    // In Rotated Array You will find the min element to track the elements
    public static int minSearch(int[] arr){
        int left =0;
        int right = arr.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(mid>0 && arr[mid-1] > arr[mid]){
                return mid;
            }
            else if(arr[left] <= arr[mid] && arr[mid] > arr[right]){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return left;
    }
}
