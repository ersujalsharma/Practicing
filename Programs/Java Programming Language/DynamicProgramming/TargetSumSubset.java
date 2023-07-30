package DynamicProgramming;

public class TargetSumSubset {
    public static void main(String[] args) {
        int arr[] = {4,2,7,1,3};
        int sum = 10;
        System.out.println(targetSumSubset(arr, sum));
    }
    public static boolean targetSumSubset(int[] arr,int sum){
        boolean dp[][] = new boolean[arr.length+1][sum+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int v = arr[i-1];
                if(v<=j && dp[i-1][j-v] == true){
                    dp[i][j] = true;
                } 
                else if(dp[i-1][j] == true){
                    dp[i][j] = true;
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
