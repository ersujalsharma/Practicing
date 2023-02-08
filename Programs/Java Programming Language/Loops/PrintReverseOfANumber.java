package Loops;

public class PrintReverseOfANumber {
    public static void main(String[] args) {
        int n = 10899;
        int newNumber=0;
        while(n>0){
            newNumber = newNumber*10+n%10;
            n/=10;
        }
        System.out.println(newNumber);
    }
}
