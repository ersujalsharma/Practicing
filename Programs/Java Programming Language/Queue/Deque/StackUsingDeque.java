package Queue.Deque;

import java.util.Deque;
import java.util.LinkedList;

public class StackUsingDeque {
    static class Stack{
        static Deque<Integer> deque = new LinkedList<>();
        public static boolean isEmpty(){
            return deque.isEmpty();
        }
        public static void push(int data){
            deque.addLast(data);
        }
        public static int pop(){
            if(isEmpty()) return -1;
            return deque.removeLast();
        }
        public static int peek(){
            if(isEmpty()) return -1;
            return deque.getLast();
        }
    }
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        while(!stack.isEmpty()){
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
