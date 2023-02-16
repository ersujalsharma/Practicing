package Queue.Deque;

import java.util.Deque;
import java.util.LinkedList;

public class QueueUsingDeque {
    static class Queue{
        static Deque<Integer> deque = new LinkedList<>();
        public static boolean isEmpty(){
            return deque.isEmpty();
        }
        public static void add(int data){
            deque.addLast(data);
        }
        public static int remove(){
            if(isEmpty()) return -1;
            return deque.removeFirst();
        }
        public static int peek(){
            if(isEmpty()) return -1;
            return deque.getFirst();
        }
    }
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        while(!queue.isEmpty()){
            System.out.print(queue.peek()+" ");
            queue.remove();
        }
    }
}
