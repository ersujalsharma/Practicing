package GreedyAlgorithms.Assignments;

public class KthLargestOddNumberInRange {
    public static void main(String[] args) {
        int l = -10;
        int r = 10;
        int k = 8;
        int ans = kthLargest(l,r,k);
        System.out.println(ans);
    }

    private static int kthLargest(int l, int r, int k) {
        if(2*(k-1)+1<l || 2*(k-1)<l){
            return 0;
        }
        if(r%2!=0){
            return r-2*(k-1);
        }
        else{
            return r-(2*(k-1)+1);
        }
    }
}
