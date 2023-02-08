package Strings;

/**
 * StringCompression
 */
public class StringCompression {

    public static void main(String[] args) {
        String str = "aaabbcccdd";
        String newStr="";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int count =1;
            while (i<str.length()-1 && c==str.charAt(i+1)) {
                count++;
                i++;
            }
            if(count>1){
                newStr+=c+""+count;
            }
            else{
                newStr+=c;
            }
        }
        System.out.println(newStr);
    }
}