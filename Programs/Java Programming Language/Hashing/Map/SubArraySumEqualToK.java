package Hashing.Map;

import java.util.HashMap;

public class SubArraySumEqualToK {
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        int k = 3;
        int ans = countSubArraysWithSumK(arr,k);
        System.out.println(ans);
    }

    private static int countSubArraysWithSumK(int[] arr, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        int ans = 0;
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            System.out.println(hm);
            sum+=arr[i];
            if(hm.containsKey(sum-k)){
                ans+= hm.get(sum-k);
            }
            hm.put(sum, hm.getOrDefault(sum, 0) +1);
        }
        return ans;
    }
    
}
