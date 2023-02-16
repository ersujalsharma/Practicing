package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingLetter {
    public static void main(String[] args) {
        String str = "aabccxb";
        int map[] = new int[26];
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            q.add(str.charAt(i));
            map[str.charAt(i)-'a']++;
            setTheFirstAsNonRepeating(q,map);
        }
    }

    private static void setTheFirstAsNonRepeating(Queue<Character> q, int[] map) {
        while(!q.isEmpty() && map[q.peek()-'a']>1){
                q.remove();
        }
        if(q.isEmpty()){ 
            System.out.print(-1+" ");
        }
        else{
            System.out.print(q.peek()+  " ");
        }
    }
}
