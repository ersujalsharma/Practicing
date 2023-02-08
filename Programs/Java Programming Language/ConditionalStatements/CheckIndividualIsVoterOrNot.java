package ConditionalStatements;

import java.util.Scanner;

public class CheckIndividualIsVoterOrNot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();
        if(age<18){
            System.out.println("Not Valid");
        }
        else{
            System.out.println("Voter");
        }
    }
}
