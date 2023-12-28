package Programs.CodeForces;

import java.util.*;

public class Solution {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        if((n*m)%2==0){
            System.out.println("Malvika");
        }
        else{
            System.out.println("Akshat");
        }
    }
}