import java.util.*;
public class Solution {
    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int target)
    {
        //    Write your code here.
        Collections.sort(arr);
        HashSet<ArrayList<Integer>> list = new HashSet<>();
        ArrayList<Integer> innerList = new ArrayList<>();
        help(arr, 0, target, innerList, list);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>(list);
        return ans;
    }
    private static void help(ArrayList<Integer> arr, int index, int target, ArrayList<Integer> innerList, HashSet<ArrayList<Integer>> list) {
        if(index == arr.size()){
            if(target==0){
                list.add(new ArrayList<>(innerList));
            }
            return;
        }
        innerList.add(arr.get(index));
        help(arr, index+1, target-arr.get(index), innerList, list);
        innerList.remove(innerList.size()-1);
        help(arr, index+1, target, innerList, list);
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(1);
        list.add(2);
        list.add(7);
        list.add(6);
        list.add(1);
        list.add(5);
        System.out.println(combinationSum2(list, 7, 8));
    }
}