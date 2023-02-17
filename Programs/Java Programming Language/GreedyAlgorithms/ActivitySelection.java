package GreedyAlgorithms;

public class ActivitySelection {
    public static void main(String[] args) {
        int[] start = {10,12,20};// {1,3,0,5,8,5};
        int[] end ={20,25,30};// {2,4,6,7,9,9}; // sorted
        int ans = countActivity(start,end);
        System.out.println(ans);
    }

    private static int countActivity(int[] start, int[] end) {
        int count =1;
        int prevEnd = end[0];
        for (int i = 1; i < end.length; i++) {
            if(start[i]>=prevEnd){ // non overlapping
                count++;
                prevEnd = end[i];
            }
        }
        return count;
    }
}
