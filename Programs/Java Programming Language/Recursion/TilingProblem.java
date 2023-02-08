package Recursion;

public class TilingProblem {
    public static void main(String[] args) {
        int n = 5;
        int ans = tilingProblem(n);
        System.out.println(ans);
    }

    private static int tilingProblem(int n) {
        if(n==0 || n==1){
            return 1;
        }
        // int verticalTiles = tilingProblem(n-1);
        // int horizontalTiles = tilingProblem(n-2);
        // int totalWays = verticalTiles+horizontalTiles;
        // return totalWays;
        return tilingProblem(n-1)+tilingProblem(n-2);
    }
    
}
