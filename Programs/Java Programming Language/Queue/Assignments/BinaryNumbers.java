package Queue.Assignments;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumbers {
    public static void main(String[] args) {
        int n = 5;
        printBinaryNumbers(n);
    }

    private static void printBinaryNumbers(int n) {
        
        Queue<String> q = new LinkedList<>();
        q.add("1");
        while(n-->0){
            String s1 = q.peek();
            System.out.println(s1); 
            q.remove();
            q.add(s1+"0");
            q.add(s1+"1");
        }
    }
}
