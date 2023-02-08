package Strings;

public class CheckTwoStringsAreAnagramsOrNot {
    public static void main(String[] args) {
        String str1 = "race";
        String str2 = "ccre";
        int strfreqarr[] = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            strfreqarr[str1.charAt(i)-'a']++;
        }
        for (int i = 0; i < str2.length(); i++) {
            strfreqarr[str2.charAt(i)-'a']--;
        }
        for (int i = 0; i < strfreqarr.length; i++) {
            if (strfreqarr[i]!=0) {
                System.out.println("Not Anagrams");
                return;
            }
        }
        System.out.println("both are Anagrams");
    }
}
