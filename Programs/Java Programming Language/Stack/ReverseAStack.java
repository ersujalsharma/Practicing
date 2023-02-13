package Stack;

import java.util.Stack;

public class ReverseAStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        reverseStack(stack);
        System.out.println(stack);
    }

    static void reverseStack(Stack<Integer> stack) {
        if(stack.isEmpty()){
            return;
        }    
        int val = stack.pop();
        reverseStack(stack);
        pushAtBottom(stack,val);
    }

    static void pushAtBottom(Stack<Integer> stack, int val) {
        if(stack.isEmpty()){
            stack.push(val);
            return;
        }
        int popped = stack.pop();
        pushAtBottom(stack, val);
        stack.push(popped);
    }
}
