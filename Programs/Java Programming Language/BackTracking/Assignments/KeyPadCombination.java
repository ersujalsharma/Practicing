package BackTracking.Assignments;

import java.util.Scanner;

public class KeyPadCombination {
    static String[] arr= {"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String digits = scanner.next();
        helperfunction(digits,0,"");
    }
    private static void helperfunction(String digits, int i, String string) {
        if(i==digits.length()){
            System.out.println("Reached ---- > "+string);
            return;
        }
        String keysvalue = arr[(int)(digits.charAt(i)-'1')];
        for(int j=0;j<keysvalue.length();j++){
            helperfunction(digits, i+1, string+keysvalue.charAt(j));
        }
    }
}
