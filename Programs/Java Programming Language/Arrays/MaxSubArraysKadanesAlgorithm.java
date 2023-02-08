package Arrays;

public class MaxSubArraysKadanesAlgorithm {
    public static void main(String[] args) {
        int[] arr = {-2,-3,-4,-1,-2,1,5,-3};
        int current_sum =0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            current_sum += arr[i];
            if(current_sum<0){
                current_sum =0;
            }
            maxSum = Math.max(current_sum,maxSum);
        }
        System.out.println(maxSum);
        // if all negative then return the smallest element
    }
}
