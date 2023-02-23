package GreedyAlgorithms.Assignments;

public class MaxmimumBalancedStringPartition {
    public static void main(String[] args) {
        String str = "LLRRRLLRRL";
        int max = maxBalancedPartition(str);
        System.out.println(max);
    }

    private static int maxBalancedPartition(String str) {
        int l = 0;
        int r = 0;
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'L'){
                l++;
            }
            else if(str.charAt(i)=='R'){
                r++;
            }
            if(l==r){
                ans++;
            }
        }
        return ans;
    }
}
