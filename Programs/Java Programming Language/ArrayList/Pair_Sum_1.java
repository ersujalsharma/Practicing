package ArrayList;

import java.util.ArrayList;

/**
 * Pair_Sum_1
 */
public class Pair_Sum_1 {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        // arr.add(1);
        // arr.add(2);
        // arr.add(3);
        // arr.add(4);
        // arr.add(5);
        // arr.add(6);
        arr.add(11);
        arr.add(15);
        arr.add(6);
        arr.add(8);
        arr.add(9);
        arr.add(10);
        int target = 16;
        // boolean val = checkPairExistOrNotInSortedArrayList(arr,target); 
        boolean val = checkPairExistOrNotInSortedAndRotatedArrayListOptimized(arr,target);
        System.out.println(val);
    }

    private static boolean checkPairExistOrNotInSortedAndRotatedArrayListOptimized(ArrayList<Integer> arr, int target) {
        // find the breaking point\
        int leftPointer = 0;
        int rightPointer = 0;
        for (int i = 0; i < arr.size(); i++) {
            if(i+1<arr.size() && arr.get(i)>arr.get(i+1)){
                leftPointer = i+1;
                rightPointer = i;
            }
        }
        while(leftPointer!=rightPointer){
            if(arr.get(rightPointer)+arr.get(leftPointer)==target){
                return true;
            }
            else if(arr.get(rightPointer)+arr.get(leftPointer)<target){
                leftPointer = (leftPointer+1)%arr.size();
            }
            else{
                rightPointer = (arr.size()+rightPointer-1)%arr.size();
            }
        }
        return false;
    }

    private static boolean checkPairExistOrNotInSortedAndRotatedArrayList(ArrayList<Integer> arr, int target) {
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i+1; j < arr.size(); j++) {
                if(arr.get(i)+arr.get(j)==target){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkPairExistOrNotInSortedArrayList(ArrayList<Integer> arr, int target) {
        int i=0;
        int j=arr.size()-1;
        while(i<j){
            if(arr.get(i)+arr.get(j)<target){
                i++;
            }
            else if(arr.get(i)+arr.get(j)>target){
                j--;
            }
            else{
                return true;
            }
        }
        return false;
    }
}