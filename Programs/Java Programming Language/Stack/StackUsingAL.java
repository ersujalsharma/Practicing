package Stack;

import java.util.ArrayList;

public class StackUsingAL {
    static class Stack{
        static ArrayList<Integer> list = new ArrayList<>();
        public static boolean isEmpty(){
            return list.size() == 0;
        }
        //push
        public static void push(int data){
            list.add(data);
        }
        //pop
        public static int pop(){
            if(list.isEmpty()){
                return -1;
            }
            return list.remove(list.size()-1);
        }
        //pop
        public static int peek(){
            if(list.isEmpty())
                return -1;
            return list.get(list.size()-1);
        }
    }
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
