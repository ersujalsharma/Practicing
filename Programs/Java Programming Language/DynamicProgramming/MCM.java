package DynamicProgramming;

public class MCM {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3};
        int dp[][] = new int[arr.length][arr.length];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp.length;j++){
                dp[i][j] = -1;
            }
        }
        int ans = findMinCostMul(arr,1,arr.length-1,dp);
        System.out.println(ans);
    }

    private static int findMinCostMul(int[] arr,int i,int j,int[][] dp) {
        if(i==j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int finalcost = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int cost1 = findMinCostMul(arr, i, k, dp); // arr[i-1]*arr[k]
            int cost2 = findMinCostMul(arr, k+1, j, dp);// arr[k]*arr[j]
            int cost3 = arr[i-1]*arr[k]*arr[j];
            finalcost = Math.min(finalcost, cost3+cost1+cost2);
        }
        return dp[i][j] =  finalcost;
    }
}
