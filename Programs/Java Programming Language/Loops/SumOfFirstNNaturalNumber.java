package Loops;

import java.util.Scanner;

public class SumOfFirstNNaturalNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        while(n>0){
            sum+=n;
            n--;
        }
        System.out.println(sum);
    }
}
