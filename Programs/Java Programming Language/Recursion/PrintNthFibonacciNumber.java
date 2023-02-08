package Recursion;

public class PrintNthFibonacciNumber {
    public static void main(String[] args) {
        int ans = fib(8);
        System.out.println(ans);
    }

    private static int fib(int i) {
        if(i==1 || i == 0){
            return i;
        }
        return fib(i-1)+fib(i-2);
    }
    
}
