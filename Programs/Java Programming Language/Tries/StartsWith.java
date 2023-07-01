package Tries;

public class StartsWith {

    private static boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
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

    public static void main(String[] args) {
        String words[] = { "apple", "app", "mango", "man", "woman" };
        for (String string : words) {
            insert(string);
        }
        String prefix = "app";
        boolean val = startsWith(prefix);
        System.out.println(val);
    }

}
