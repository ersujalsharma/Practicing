package Recursion;

public class PrintNumbersFromNto1 {
    public static void main(String[] args) {
        PrintNumbersFromNto1 p = new PrintNumbersFromNto1();
        p.functionToPrintNto1(20);
    }
    void functionToPrintNto1(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        functionToPrintNto1(n-1);
    }
}
