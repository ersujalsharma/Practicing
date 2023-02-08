package Arrays;

/**
 * MaxSubArraySum2 Using Prefix Array
 */
public class MaxSubArraySum2 {

    public static void main(String[] args) {
        int arr[] = {1,-2,6,-1,3};
        int currsum =0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i-1]+arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = 0; j < arr.length; j++) {
                int end = j;
                currsum = start == 0 ? prefix[end] : prefix[end] - prefix[start-1];  
                if(currsum>maxSum){
                    maxSum = currsum;
                }
            }
        }
        System.out.println(maxSum);
    }
}