package Two_D_Arrays;

public class SearchSmallestAndLargestIn2DArrays {
    public static void main(String[] args) {
        int[][] arr = {
            {1,9,3},
            {4,7,5},
            {2,8,6}
        };
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                smallest = Math.min(smallest, arr[i][j]);
                largest = Math.max(largest, arr[i][j]);
            }
        }
        System.out.println("Smallest is "+smallest+" Largest is "+largest);
    }
}
