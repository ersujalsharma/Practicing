package ConditionalStatements;

import java.util.Scanner;

public class IncomeTaxCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int salary = scanner.nextInt();
        int tax;
        if(salary >= 10_00_000){
            tax = (int)(salary*0.3);
        }
        else if(salary>=5_00_000 && salary<10_00_000){
            tax = (int)(salary*0.2);
        }
        else{
            tax = 0;
        }
        System.out.println(tax);
    }
}
