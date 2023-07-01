package Tries;

public class WordBreakProblem {
    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;
        Node(){
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
        }
    }
    static Node root = new Node();
    
    private static boolean exist(String key) {
        if(key.length()==0) return true;
        for(int i=1;i<=key.length();i++){
            if(searchLL(key.substring(0, i)) &&
                exist(key.substring(i))){
                    return true;
            }
        }
        return false;
    }
    public static boolean searchLL(String str){
        Node curr = root;
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }
    public static void insert(String words){
        Node curr = root;
        for (int level = 0; level < words.length(); level++) {
            int idx = words.charAt(level)-'a';
            if(curr.children[idx]==null){
                Node node = new Node();
                curr.children[idx] = node;
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }



    public static void main(String[] args) {
        String[] words = {"i","like","sam","samsung","mobile","ice"};
        for (String string : words) {
            insert(string);
        }
        String key = "ilikesamsung";
        boolean ans = exist(key);
        System.out.println(ans);
    }





}
