package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class InterleaveTwoHalvesOfAQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        interLeave(q);
        System.out.println(q);
    }

    private static void interLeave(Queue<Integer> q) {
        Queue<Integer> queue = new LinkedList<>();
        int size = q.size()/2;
        for (int i = 0; i < size; i++) {
            queue.add(q.remove());
        }
        while(!queue.isEmpty()) {
            q.add(queue.remove());
            q.add(q.remove());
        }
    }
}
