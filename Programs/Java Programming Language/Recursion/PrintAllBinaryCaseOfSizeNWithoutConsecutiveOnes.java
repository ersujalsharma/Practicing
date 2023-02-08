package Recursion;

public class PrintAllBinaryCaseOfSizeNWithoutConsecutiveOnes {
    public static void main(String[] args) {
        generatingBinaryString(3,"");
    }

    private static void generatingBinaryString(int i,String str) {
        if(i == 0 ){
            System.out.println(str);
            return;
        }
        generatingBinaryString(i-1, str+'0');
        if(str.length()>0 && str.charAt(str.length()-1) =='0'){
            return;
        }
        generatingBinaryString(i-1, str+'1');
    }
}
