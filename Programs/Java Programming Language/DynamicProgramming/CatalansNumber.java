package DynamicProgramming;

import java.util.Arrays;

public class CatalansNumber {
    public static void main(String[] args) {
        int n = 30;
        long dp[] = new long[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = 0;
            for(int j=0;j<i;j++){
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        System.out.println(dp[n]);
        // Arrays.fill(dp,-1);
        // long ans = cat(n,dp);
        // System.out.println(ans);
    }

    // private static long cat(int n, long[] dp) {
    //     if(n==0 || n==1){
    //         return 1;
    //     }
    //     if(dp[n] !=-1) return dp[n];
    //     long ans = 0;
    //     for (int i = 0; i < n; i++) {
    //         ans += cat(i,dp) * cat(n-i-1,dp);
    //     }
    //     return dp[n] = ans;
    // }
    
}
