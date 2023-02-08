package Recursion;

public class RemoveDuplicatesInAString {
    public static void main(String[] args) {
        String str = "appnnacollege";
        boolean[] arr = new boolean[26];
        removeDuplicatesInAString(str,0,new StringBuilder(),arr);
    }

    private static void removeDuplicatesInAString(String str, int i, StringBuilder string, boolean[] arr) {
        if(i==str.length()){
            System.out.println(string);
            return;
        }
        if(arr[str.charAt(i)-'a'])
            removeDuplicatesInAString(str, i+1, string,arr);
        else{
            arr[str.charAt(i)-'a'] = true;
            removeDuplicatesInAString(str, i+1, string.append(str.charAt(i)), arr);
        }
    }
}
