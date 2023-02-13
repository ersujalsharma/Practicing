package Stack.Assignments;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String str = "100[leetcode]";
        // String str2 = "2[cv]";
        String ans = decodeString(str);
        System.out.println(ans);
    }

    private static String decodeString(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ']') {
                String temp = "";
                while (!stack.isEmpty() && stack.peek() != '[') {
                    temp = stack.pop()+temp;
                }
                    stack.pop();
                    String occurence="";
                    while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                        occurence =stack.pop()+occurence;
                    }
                    int occurence1 = Integer.parseInt(occurence);
                    while (occurence1-- > 0) {
                        for (int j = 0; j < temp.length(); j++) {
                            stack.push(temp.charAt(j));
                        }
                    }
            }
            else {
                stack.push(str.charAt(i));
                System.out.println(stack);
            }
        }
        reverse(stack);
        str = "";
        while(!stack.isEmpty()){
            str+=stack.pop();
        }
        return str;
    }

    private static void reverse(Stack<Character> stack) {
        if(stack.isEmpty()){
            return;
        }    
        char val = stack.pop();
        reverse(stack);
        pushAtBottom(stack,val);
    }
    static void pushAtBottom(Stack<Character> stack, char val) {
        if(stack.isEmpty()){
            stack.push(val);
            return;
        }
        char popped = stack.pop();
        pushAtBottom(stack, val);
        stack.push(popped);
    }
}
