package Tries;

public class UniqueSubstrings {
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

    public static void main(String[] args) {
        String s = "ababa";
        String[] str = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            str[i] = s.substring(i);
        }
        for (String string : str) {
            insert(string);
        }
        int res = countAllNodes(root);
        System.out.println(res);
    }

    private static int countAllNodes(Node root) {
        int count = 0;
        for (int i = 0; i < root.children.length; i++) {
            if(root.children[i]!=null){
                count += countAllNodes(root.children[i]);
            }
        }
        return count+1;
    }
}
