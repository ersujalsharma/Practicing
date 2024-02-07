import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int max = (a*b)+c;
        max = Math.max(max,(a*b)*c);
        max = Math.max(max,(a+b)+c);
        max = Math.max(max,(a+b)*c);
        max = a*(b+c);
        max = Math.max(max,a*(b*c));
        max = Math.max(max,a+(b+c));
        max = Math.max(max,a+(b*c));
        System.out.println(max);
    }
}
