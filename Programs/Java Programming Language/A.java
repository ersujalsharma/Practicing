import java.util.*;

class Isomorphic{
    // This function returns true if str1 and str2 are ismorphic
    // else returns false
    public static boolean areIsomorphic(String S1,String S2)
    {
        // Your code here
        if(S1.length()!=S2.length()) return false;
        HashMap<Character,Character> hashmap = new HashMap<>();
        for(int i=0;i<S1.length();i++){
            if(hashmap.containsKey(S1.charAt(i)) && hashmap.get(S1.charAt(i))!=S2.charAt(i)) return false;
            else{
                hashmap.put(S1.charAt(i),S2.charAt(i));
            }
        }
        for(int i=0;i<S1.length();i++){
            if(hashmap.containsKey(S2.charAt(i)) && hashmap.get(S2.charAt(i))!=S1.charAt(i)) return false;
            else{
                hashmap.put(S2.charAt(i),S1.charAt(i));
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(areIsomorphic("aab", "xzy"));
    }
}