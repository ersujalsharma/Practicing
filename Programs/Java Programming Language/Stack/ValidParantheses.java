package Stack;

import java.util.Stack;

public class ValidParantheses {
    public static void main(String[] args) {
        String str = "){}";
        boolean val = checkValidParantheses(str);
        System.out.println(val);
    }

    private static boolean checkValidParantheses(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }
           else {
                if(stack.isEmpty())
                    return false;
                if(
                   ( stack.peek() == '(' && ch == ')' ) || 
                   ( stack.peek() == '[' && ch == ']' ) ||  
                   ( stack.peek() == '{' && ch == '}' ) 
                )
                stack.pop();
           }
        }
        if(stack.isEmpty())
            return true;
        return false;
    }
}
