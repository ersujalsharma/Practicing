package Hashing.Map;

import java.util.HashMap;

/**
 * ValidAnagrams
 */
public class ValidAnagrams {

    public static void main(String[] args) {
        String s = "sujal";
        String t = "lajus";
        boolean val = validAnagrams(s, t);
        System.out.println(val);
    }

    private static boolean validAnagrams(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character,Integer> hashmap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            hashmap.put(s.charAt(i),hashmap.getOrDefault(s.charAt(i), 0)+1);
        }
        for (int i = 0; i < t.length(); i++) {
            if(hashmap.containsKey(t.charAt(i))){
                if(hashmap.get(t.charAt(i))>1)
                    hashmap.put(t.charAt(i), hashmap.get(t.charAt(i))-1);
                else{
                    hashmap.remove(t.charAt(i));
                }
            }
            else{
                System.out.println("Not Valid");
                return false;
            }
        }
        if (!hashmap.isEmpty()) {
            return false;
        }
        return true;
    }
}
