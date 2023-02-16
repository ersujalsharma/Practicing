package Queue;

import java.util.Stack;

public class QueueUsingTwoStacks {
    static class Queue{
        Stack<Integer> mainStack = new Stack<>();
        Stack<Integer> tempStack = new Stack<>();
        public boolean isEmpty(){
            return mainStack.size()==0;
        }
        public void push(int data){
            while(!mainStack.isEmpty()){
                tempStack.push(mainStack.pop());
            }
            tempStack.push(data);
            while(!tempStack.isEmpty()){
                mainStack.push(tempStack.pop());
            }
        }      
        public int pop(){
            if(mainStack.isEmpty()){
                System.out.println("STACK EMPTY");
                return -1;
            }
            return mainStack.pop();
        }
        public int peek(){
            if(mainStack.isEmpty()){
                System.out.println("STACK EMPTY");
                return -1;
            }
            return mainStack.peek();
        }
    }
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.push(2);
        queue.push(3);
        queue.push(1);
        while(!queue.isEmpty()){
            System.out.println(queue.pop());
        }
    }
}
