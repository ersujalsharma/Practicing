package Recursion;

public class PrintNumber1toN {
    public static void main(String[] args) {
        printNumber1toN(5);
    }
    static void printNumber1toN(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        printNumber1toN(n-1);
        System.out.println(n);
    }
}
