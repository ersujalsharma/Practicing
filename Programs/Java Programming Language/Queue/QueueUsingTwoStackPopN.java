package Queue;

import java.util.Stack;

/**
 * QueueUsingTwoStackPopN
 */
public class QueueUsingTwoStackPopN {
    static class Queue{
        static Stack<Integer> mainStack = new Stack<>();
        static Stack<Integer> tempStack = new Stack<>();
        public static boolean isEmpty(){
            return mainStack.isEmpty();
        }
        public static void push(int data){
            mainStack.push(data);
        }
        public static int pop(){
            if(isEmpty()){
                System.out.println("Empty Stack");
                return -1;
            }
            while(!mainStack.isEmpty()){
                tempStack.push(mainStack.pop());
            }
            int data = tempStack.pop();
            while(!tempStack.isEmpty()){
                mainStack.push(tempStack.pop());
            }
            return data;
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("Empty Stack");
                return -1;
            }
            while(!mainStack.isEmpty()){
                tempStack.push(mainStack.pop());
            }
            int data = tempStack.peek();
            while(!tempStack.isEmpty()){
                mainStack.push(tempStack.pop());
            }
            return data;
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.push(2);
        queue.push(3);
        queue.push(1);
        while(!queue.isEmpty()){
            System.out.println(queue.peek());
            queue.pop();
        }
    }
}