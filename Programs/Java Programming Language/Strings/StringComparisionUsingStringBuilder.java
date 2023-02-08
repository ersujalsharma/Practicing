package Strings;

/**
 * StringComparisionUsingStringBuilder
 */
public class StringComparisionUsingStringBuilder {

    public static void main(String[] args) {
        String str = "aaabbcccd";
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int count =1;
            while (i<str.length()-1 && str.charAt(i+1)==ch) {
                i++;
                count++;
            }
            if(count>1)
            strBuilder.append(ch+""+count);
            else
                strBuilder.append(ch);
        }
        System.out.println(strBuilder);
    }
}