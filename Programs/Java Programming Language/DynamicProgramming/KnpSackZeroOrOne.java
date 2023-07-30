package DynamicProgramming;

public class KnpSackZeroOrOne {
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;
        int ans = knapsack(val,wt,W,0);
        System.out.println(ans);
        int dp[][] = new int[val.length+1][W+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        int ans2 = knapsackDPMEM(val,wt,W,0,dp);
        System.out.println(ans2);
    }
    // O(n*W) Memoization of array of no of variables
    private static int knapsackDPMEM(int[] val, int[] wt, int W, int i, int[][] dp) {
        if(W==0 || i == val.length) return 0;
        if(dp[i][W] != -1) return dp[i][W];
        if(wt[i]<=W){
            //--------- valid -------------
            // include 
            int ans1 = val[i]+knapsack(val, wt, W-wt[i], i+1);
            // exclude
            int ans2 = knapsack(val, wt, W, i+1);
            dp[i][W] =  Math.max(ans1,ans2);
        }
        else{ 
            // not able to add
            dp[i][W] =  knapsack(val, wt, W, i+1);
        }
        return dp[i][W];
    }

    private static int knapsack(int[] val, int[] wt, int W, int i) {
        if(W==0 || i == val.length) return 0;
        if(wt[i]<=W){
            //--------- valid -------------
            // include 
            int ans1 = val[i]+knapsack(val, wt, W-wt[i], i+1);
            // exclude
            int ans2 = knapsack(val, wt, W, i+1);
            return Math.max(ans1,ans2);
        }
        else{ 
            // not able to add
            return knapsack(val, wt, W, i+1);
        }
    }
}
