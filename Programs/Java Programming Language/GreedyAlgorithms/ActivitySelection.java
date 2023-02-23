package GreedyAlgorithms;

import java.util.ArrayList;

public class ActivitySelection {
    public static void main(String[] args) {
        int[] start = {1,3,0,5,8,5};
        int[] end ={2,4,6,7,9,9}; // sorted
        ArrayList<String> elements = new ArrayList<>();
        int ans = countActivity(start,end,elements);
        System.out.println(elements);
        System.out.println(ans);
    }

    private static int countActivity(int[] start, int[] end,ArrayList<String> arrayList) {
        int count =0;
        int prevEnd = -1;
        for (int i = 0; i < end.length; i++) {
            if(start[i]>=prevEnd){ // non overlapping
                count++;
                prevEnd = end[i];
                arrayList.add("A"+i);
            }
        }
        System.out.println();
        return count;
    }
}
