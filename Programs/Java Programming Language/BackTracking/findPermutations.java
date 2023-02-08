package BackTracking;

public class findPermutations {
    public static void main(String[] args) {
        String str = "abc";
        findPermutations(str,"");
    }

    private static void findPermutations(String str, String newString) {
        if(str.length()==0){
            System.out.println(newString);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            String newstr = str.substring(0, i)+str.substring(i+1);
            findPermutations(newstr, newString+currentChar);
        }
    }
}
