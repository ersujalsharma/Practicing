package Hashing.Map;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int arr[] = {1,2};
        HashMap<Integer,Integer> hashmap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hashmap.put(arr[i], hashmap.getOrDefault(arr[i],0)+1);
        } 
        int allowed = arr.length/3;
        for (Map.Entry<Integer,Integer> e : hashmap.entrySet()) {
            if(hashmap.get(e.getKey())>allowed){
                System.out.println(e.getKey());
            }
        }
    }
}