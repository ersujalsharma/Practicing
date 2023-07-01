package Hashing.Map;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LinkedHashMapCode {
    public static void main(String[] args) {
        LinkedHashMap<String,Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 100);
        lhm.put("Us", 200);
        lhm.put("China", 150);
        System.out.println(lhm);
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("Us", 200);
        hm.put("China", 150);
        System.out.println(hm);
        for (String string : hm.keySet()) {
            System.out.print(string+" ");
        }
    }
}
