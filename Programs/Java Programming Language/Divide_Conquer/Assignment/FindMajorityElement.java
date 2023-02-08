package Divide_Conquer.Assignment;

public class FindMajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        /*   MY APPROACH
        int[] frr = new int[10];
        for (int i=0;i<nums.length;i++) {
            frr[nums[i]]++;
        }
        int max = Integer.MIN_VALUE;
        int max_index=-1;
        for (int i=0;i<frr.length;i++) {
            if(frr[i]>max){
                max = frr[i];
                max_index=i;
            }
        }
        System.out.println(max_index);
        */
        findMajorityElement(nums);
    }

    private static void findMajorityElement(int[] nums) {
        int result = majorityElement(nums,0,nums.length-1);
        System.out.println(result);
    }

    private static int majorityElement(int[] nums, int low, int high) {
        if(low == high) return nums[low];
        int mid = low+(high-low)/2;
        int left = majorityElement(nums, low, mid);
        int right = majorityElement(nums, mid+1, high);
        if(left==right){
            return left;
        }
        int leftCount = countInRange(nums, left, low, high);
        int rightCount = countInRange(nums, right, low, high);
        return leftCount>rightCount?leftCount:rightCount;
    }

    private static int countInRange(int[] nums, int num, int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if(nums[i]==num){
                count++;
            }
        }
        return count;
    }

}
