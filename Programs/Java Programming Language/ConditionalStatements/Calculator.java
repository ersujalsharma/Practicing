package ConditionalStatements;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        char c = scanner.next().charAt(0) ;
        switch (c) {
            case '+':
                System.out.println(a+b);
                break;
            case '-':
                System.out.println(a-b);
                break;
            case '/':
                System.out.println(a/b);
                    break;
            case '%':
                System.out.println(a%b);
                    break;
            case '*':
                System.out.println(a*b);
                    break;  
            default:
        }
    }
}
