package Hashing.Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;


public class HashSetPracticing {
    public static void main(String[] args) {
        HashSet<Integer> hashset = new HashSet<>();
        hashset.add(1);
        hashset.add(3);
        hashset.add(1);
        hashset.add(2);
        System.out.println(hashset);
        hashset.remove(1);
        System.out.println(hashset.contains(2));
        // hashset.clear();
        System.out.println(hashset);
        Iterator<Integer> itr = hashset.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next()+" ");
        }
        for (Integer integer : hashset) {
            System.out.print(integer+" ");
        }
        //
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(1);
        lhs.add(3);
        lhs.add(1);
        lhs.add(2);
        System.out.println(lhs);

        //

        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(1);
        ts.add(3);
        ts.add(1);
        ts.add(2);
        System.out.println(ts);

    }
}
