import java.util.ArrayList;
import java.util.List;

public class Oops {
    class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
        
    }
    Node root = new Node();
    public void insert(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (curr.children[idx] == null) {
                    curr.children[idx] = new Node();
                }
                curr = curr.children[idx];
            }
            curr.eow = true;
        }

        public String searched(String word) {
            StringBuilder str = new StringBuilder();
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (curr.children[idx] == null) {
                    return word;
                }
                str.append(word.charAt(i));
                if (curr.children[idx].eow == true) {
                    return str.toString();
                }
                curr = curr.children[idx];
            }
            return word;
        }

    public String replaceWords(List<String> dictionary, String sentence) {
        for (int i = 0; i < dictionary.size(); i++) {
            insert(dictionary.get(i));
        }
        String[] str = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            String searched = searched(str[i]);
            sb.append(searched);
            if (i < str.length) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("bat");
        list.add("cat");
        list.add("rat");
        String sentence = "the cattle was rattled by the battery";
        Oops oops = new Oops();
        String ans = oops.replaceWords(list, sentence);
        System.out.println(ans);

    }
}

class Random {
    String name = "Chair";

    void toSit() {
        System.out.println("You can sit here");
    }

    public Random() {
    }
}