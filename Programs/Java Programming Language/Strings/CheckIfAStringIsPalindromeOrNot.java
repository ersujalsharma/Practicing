package Strings;

public class CheckIfAStringIsPalindromeOrNot {
    public static void main(String[] args) {
        String str = "Sujal";
        int i=0;
        int j=str.length()-1;
        while (i<j) {
            if(str.charAt(i)!=str.charAt(j)){
                System.out.println(false);
                return;
            }
            i++;
            j--;
        }
        System.out.println(true);
    }

}
