package DynamicProgramming;

public class LCS {
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";
        int dp[][] = new int[str1.length()+1][str2.length()+1];
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[dp.length-1][dp[0].length-1]);
        // int dp[][] = new int[str1.length()+1][str2.length()+1];
        // for(int i=0;i<dp.length;i++){
        //     for (int j = 0; j < dp[0].length; j++) {
        //         dp[i][j] = -1;
        //     }
        // }
        // int ans = lcs(str1,str1.length(),str2,str2.length(),dp);
        // System.out.println(ans);
        // int count = 0;
        // int j =0;
        // for(int i=0;i<str1.length();i++){
        //     for(int k=j;k<str2.length();k++){
        //         if(str1.charAt(i)==str2.charAt(k)){
        //             j =k+1;
        //             count++;
        //         }
        //     }
        // }
        // System.out.println(count);
    }

    private static int lcs(String str1, int length1, String str2, int length2, int[][] dp) {
        if(length1==0 || length2==0) return 0;
        if(dp[length1][length2]!=-1) return dp[length1][length2];
        if(str1.charAt(length1-1)==str2.charAt(length2-1)){
            return dp[length1][length2] = 1+lcs(str1, length1-1, str2, length2-1,dp);
        }
        else{
            int left = lcs(str1, length1-1, str2, length2,dp);
            int right = lcs(str1, length1, str2, length2-1,dp);
            return Math.max(left, right);
        }
    }
}
