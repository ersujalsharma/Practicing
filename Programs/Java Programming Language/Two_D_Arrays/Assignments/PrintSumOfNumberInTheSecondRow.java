package Two_D_Arrays.Assignments;

public class PrintSumOfNumberInTheSecondRow {
    public static void main(String[] args) {
        int[][] nums = { {1,4,9},{11,4,3},{2,2,3} };
        int sum =0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[1][i];
        }
        System.out.println(sum);
    }
}
