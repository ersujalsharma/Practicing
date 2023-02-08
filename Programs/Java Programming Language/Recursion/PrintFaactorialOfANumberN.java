package Recursion;

public class PrintFaactorialOfANumberN {
    public static void main(String[] args) {
        System.out.println(fact(8));
    }
    static int fact(int n){
        if(n == 1){
            return 1;
        }
        int ans = fact(n-1);
        return n* ans ;
    }
}
