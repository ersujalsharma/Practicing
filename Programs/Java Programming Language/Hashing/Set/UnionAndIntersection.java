package Hashing.Set;

import java.util.HashSet;

public class UnionAndIntersection {
    public static void main(String[] args) {
        int arr[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            hs.add(arr[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            hs.add(arr2[i]);
        }
        int union = hs.size();
        hs.clear();
        for (int i = 0; i < arr.length; i++) {
            hs.add(arr[i]);
        }
        int intersection  =0;
        // Intersection
        for(int i=0;i<arr2.length;i++){
            if(hs.contains(arr2[i])){
                intersection++;
                hs.remove(arr2[i]);
            }
        }
        System.out.println(intersection);
        System.out.println(union);
        
    }
}
