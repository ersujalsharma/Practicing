package Tries;

public class LongestWordwithAllPrefixes {
    public static void main(String[] args) {
        String[] s = {"a","banana","app","apple","appl","ap","apply","apple"};
        for (String string : s) {
            insert(string);
        }
        longestWord(root,new StringBuilder(""));
        System.out.println(ans);
    }
    public static String ans = "";
    private static void longestWord(Node root, StringBuilder temp) {
        if(root == null){
            return;
        }
        for (int i = 0; i < 26; i++) {
            if(root.children[i]!=null && root.children[i].eow == true){
                char ch = (char)(i+'a');
                temp.append(ch);
                if(temp.length()>ans.length()){
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        Node() {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
        }
    }

    static Node root = new Node();


    public static boolean searchLL(String str) {
        Node curr = root;
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }

    public static void insert(String words) {
        Node curr = root;
        for (int level = 0; level < words.length(); level++) {
            int idx = words.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                Node node = new Node();
                curr.children[idx] = node;
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }
}
