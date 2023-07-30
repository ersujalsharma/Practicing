package DynamicProgramming;

public class Fibonacci_Recursion {
    public static void main(String[] args) {
        int n = 30;
        int ans = fibRec(n);
        int fib[] = new int[n+1];
        fib[0] = 0;
        fib[1] = 1;
        int ansDPM = fibDPMem(n,fib);
        System.out.println ("Fibonacci of "+n);
        System.out.println(ans);
        System.out.println("Calls using Recursion : "+countRec);
        System.out.println(ansDPM);
        System.out.println("Calls using DP Memoization : "+countDPM);
        int ans3 = findDPTab(n);
        System.out.println(ans3);
        System.out.println("Calls using DP Tabulation : "+countTab);
        
    }
    static int countTab =0;
    private static int findDPTab(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            countTab++;
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    static int countDPM = 0;
    private static int fibDPMem(int n,int[] fib) {
        countDPM++;
        if(n<1) return 0;
        if(fib[n]!=0) return fib[n];
        fib[n] = fibDPMem(n-1,fib)+fibDPMem(n-2,fib);
        return fib[n];
    }
    static int countRec=0;
    private static int fibRec(int n) {
        countRec++;
        if(n<=1) return n;
        int fibNM1 = fibRec(n-1);
        int fibNM2 = fibRec(n-2);
        return fibNM1+fibNM2;
    }

}
