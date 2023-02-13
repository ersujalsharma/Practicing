package Stack;

import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {6,8,0,1,3};
        int nge[] = new int[arr.length];
        findNGE(arr,nge);
        for (int i = 0; i < nge.length; i++) {
            System.out.print(nge[i]+" ");
        }
    }

    private static void findNGE(int[] arr, int[] nge) { // O(n)
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length-1; i >= 0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nge[i] = -1;
            }
            else{
                nge[i] = arr[stack.peek()];
            }
            stack.push(i);
        }
    }
}
