package Arrays.Assignment;

public class Question4_TrappingWater {
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        // create auxillary arrays to find the water level
        // by finding the min bar length between two sides
        int leftMaxSubArray[] = new int[arr.length];
        leftMaxSubArray[0] = arr[0];
        for (int i = 1; i < leftMaxSubArray.length; i++) {
            leftMaxSubArray[i] = Math.max(leftMaxSubArray[i-1], arr[i]);
        }
        int[] rightMaxSubArray = new int[arr.length];
        rightMaxSubArray[rightMaxSubArray.length-1] = arr[arr.length-1];
        for (int i = rightMaxSubArray.length-2; i >= 0; i--) {
            rightMaxSubArray[i] = Math.max(rightMaxSubArray[i+1], arr[i]);
        }
        for (int i : rightMaxSubArray) {
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i : leftMaxSubArray) {
            System.out.print(i+" ");
        }
        int watercount=0;
        // now we will count the water
        for (int i = 0; i < arr.length; i++) {
            watercount += (Math.min(leftMaxSubArray[i], rightMaxSubArray[i])-arr[i]);
        }
        System.out.println();
        System.out.println(watercount);

    }
}
