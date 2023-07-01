package Hashing.Set;

import java.util.HashSet;

public class CountDistinctElement {
    public static void main(String[] args) {
        int[] arr = {4,3,2,5,6,7,3,4,2,1};
        HashSet<Integer> hashset = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            hashset.add(arr[i]);
        }
        System.out.println(hashset.size());
    }
}
