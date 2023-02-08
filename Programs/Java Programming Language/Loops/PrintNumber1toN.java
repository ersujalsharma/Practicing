package Loops;

import java.util.Scanner;

public class PrintNumber1toN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n-->0){
            System.out.println(n);
        }
    }
}
