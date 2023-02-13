package Stack;

import java.util.Stack;

public class PushAtBottom {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        int data = 5;
    /*
    ---=--SUJAL APPROACH
        while(!stack.isEmpty()){
            temp.push(stack.pop());
        }
        temp.push(data);
        while(!temp.isEmpty()){
            stack.push(temp.pop());
        }
        while(!stack.isEmpty()){ 
            System.out.println(stack.pop());
        }
         */
        // Shraddha's Approach
        pushAtBottom(stack,data);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    private static void pushAtBottom(Stack<Integer> stack, int data) {
        if(stack.isEmpty()){
            stack.push(data);
            return;
        }
        int val = stack.pop();
        pushAtBottom(stack, data);
        stack.push(val);
    }
}
