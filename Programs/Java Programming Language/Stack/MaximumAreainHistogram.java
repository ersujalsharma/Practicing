package Stack;

import java.util.Stack;

public class MaximumAreainHistogram{
    public static void main(String[] args) {
        int height[] = {2,1,5,6,2,3};
        int area = findMaxAreaMyOptimizedApproach(height);
        System.out.println();
        System.out.println(area);
    }

    private static int findMaxAreaMyOptimizedApproach(int[] height) {
        int left[] = findNextSmallerElementInLeft(height);

        int right[] = findNextSmallerElementInRight(height);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            int area = right[i]-left[i]-1;
            area*=height[i];
            max = max>area ? max:area;
        }
        return max;
    }

    private static int[] findNextSmallerElementInRight(int[] arr) {
        Stack<Integer> stack  = new Stack<>();
        int right[] = new int[arr.length];
        for (int i = right.length-1; i >= 0 ; i--) {
            while(!stack.isEmpty() && arr[i]<=arr[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                right[i] = right.length;
            }
            else{
                right[i] = stack.peek();
            }
            stack.push(i);
        }
       return  right;
    }

    private static int[] findNextSmallerElementInLeft(int[] arr) {
        Stack<Integer> stack  = new Stack<>();
        int left[] = new int[arr.length];
        for (int i = 0; i < left.length ; i++) {
            while(!stack.isEmpty() && arr[i]<=arr[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                left[i] = -1;
            }
            else{
                left[i] = stack.peek();
            }
            stack.push(i);
        }
       return left;
    }

    private static int findMaxAreaMyApproach(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            int index = i-1;
            while(index>=0){
                if(height[index]>=height[i]){
                    index--;
                }
                else{
                    break;
                }
            }
            int left = i-index-1;
            System.out.print(left+" ");
            index = i+1;
            while(index<=height.length-1){
                if(height[index]>=height[i]){
                    index++;
                }
                else{
                    break;
                }
            }
            int right = index-i-1;
            System.out.println(right);
            int width = left+right+1;
            int hgt = height[i];
            int area = hgt*width;
            maxArea = maxArea>area ? maxArea : area;
        }
        return maxArea;
    }
}
