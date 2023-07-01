package Hashing.Map;

import java.util.HashMap;

public class HashMapping {
    public static void main(String[] args) {
        HashMap<String,Integer> hashmap = new HashMap<>();
        hashmap.put("India", 1);
        hashmap.put("Indonesia", 2);
        hashmap.put("US", 4);
        hashmap.put("Nepal", 3);
        //
        System.out.println(hashmap);
        // get
        Integer val = hashmap.get("India");
        System.out.println(val);
        val = hashmap.get("Bhutan");
        System.out.println(val);
        //
        System.out.println(hashmap);
        // containsKey
        boolean isExist = hashmap.containsKey("India");
        System.out.println(isExist);
        isExist = hashmap.containsKey("Bhutan");
        System.out.println(isExist);
        //
        System.out.println(hashmap);
        //remove
        val = hashmap.remove("India");
        System.out.println(val);
        val = hashmap.remove("Bhutan");
        System.out.println(val);
        //
        System.out.println(hashmap);
        //
        System.out.println(hashmap.size());
        System.out.println(hashmap.isEmpty());

    }
}
