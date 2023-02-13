package Stack;

import java.util.Stack;

public class ReverseStringUsingLinkedList {
    public static void main(String[] args) {
        String str = "abcd";
        str = reverseString(str);
        System.out.println(str);
    }
    public static String reverseString(String str){
        StringBuilder reverseString =new StringBuilder("");
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        while(!stack.isEmpty()){
            reverseString.append(stack.pop());
        }
        return reverseString.toString();
    }
}
