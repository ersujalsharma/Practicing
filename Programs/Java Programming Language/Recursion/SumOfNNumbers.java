package Recursion;

public class SumOfNNumbers {
    public static void main(String[] args) {
        int ans = sumOfNNumbers(5);
        System.out.println(ans);
    }
    static int sumOfNNumbers(int n){
        if(n==1){
            return 1;
        }
        return n+sumOfNNumbers(n-1);
    }
}
