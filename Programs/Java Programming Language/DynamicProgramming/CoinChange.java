package DynamicProgramming;

public class CoinChange {
    public static void main(String[] args) {
        int coin[] = {2,5,3,6};
        int sum = 10;
        int ans = coinChange(coin,sum);
        System.out.println(ans);
    }

    private static int coinChange(int[] coin, int sum) {
        int dp[][] = new int[coin.length+1][sum+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<dp.length;i++){
            for (int j = 0; j < dp[i].length; j++) {
                if(coin[i-1]<=j){
                    dp[i][j] = dp[i][j-coin[i-1]]+dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

}
