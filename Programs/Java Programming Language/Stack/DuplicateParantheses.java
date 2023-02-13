package Stack;

import java.util.Stack;

/**
 * DuplicateParantheses
 */
public class DuplicateParantheses {

    public static void main(String... args) {
        String str = "()((a+b)+(c+d))";
        boolean val = checkDuplicateParantheses(str);
        System.out.println(val);
    }

    private static boolean checkDuplicateParantheses(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == ')') {

                int count = 0;
                while (stack.peek() != '(') {
                    count++;
                    stack.pop();
                }
                if (count < 1) {
                    return true;
                } else {
                    stack.pop();
                }
            } else if (ch == ']') {

                int count = 0;
                while (stack.peek() != '[') {
                    count++;
                    stack.pop();
                }
                if (count < 1) {
                    return true;
                } else {
                    stack.pop();
                }
            } else if (ch == '}') {

                int count = 0;
                while (stack.peek() != '{') {
                    count++;
                    stack.pop();
                }
                if (count < 1) {
                    return true;
                } else {
                    stack.pop();
                }
            }
            else{
                stack.push(ch);
            }
        }
        return false;
    }
}