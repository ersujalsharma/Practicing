package Tries;

public class ImplementationOfTries {
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
    public static void main(String[] args) {
        String words[] = {"the","a","there","their","any","thee"};
        for (String string : words) {
            insert(string); // O(L) largest word length
        }
        boolean val = searchLL("there");
        System.out.println(val);
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
}
