package Loops;

import java.util.Scanner;

public class PrintNumberWhichIsNotMultipleOf10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        while(true){
            number  = scanner.nextInt();
            if(number%10 == 0){
                break;
            }
            System.out.println(number);
        }
    }
}
