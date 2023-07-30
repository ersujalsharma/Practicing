package DynamicProgramming;

import java.util.Arrays;

public class CountingWaysToStairs {
    public static void main(String[] args) {
        int n = 5;
        int ways[] = new int[n+1];
        Arrays.fill(ways,-1);
        int ans = countWays(n,ways);
        System.out.println(ans);
    }

    private static int countWays(int n,int ways[]) {
        if(n==0) return 1;
        if(n<0) return 0;
        if(ways[n]!=-1){
            return ways[n];
        }
        return ways[n] = countWays(n-1,ways)+countWays(n-2,ways);
    }
}
