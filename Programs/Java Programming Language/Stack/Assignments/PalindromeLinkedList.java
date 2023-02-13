package Stack.Assignments;

import java.util.LinkedList;
import java.util.Stack;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        LinkedList<Character> list = new LinkedList();
        list.add('A');
        list.add('B');
        list.add('C');
        list.add('B');
        list.add('A');
        boolean val = checkPalindromeOrNot(list);
        System.out.println(val);
    }

    private static boolean checkPalindromeOrNot(LinkedList<Character> list) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            stack.push(list.get(i));
        }
        for (int i = 0; i<list.size(); i++) {
            System.out.println(stack.peek() +" "+list.get(i));
            if(stack.pop() != list.get(i)){
                return false;
            }
        }
        return true;
    }
}
