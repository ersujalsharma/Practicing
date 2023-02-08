package ArrayList.Assignments;

import java.util.ArrayList;

public class MostFrequestNumberFollowingKey {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(100);
        arrayList.add(200);
        arrayList.add(1);
        arrayList.add(100);
        // arrayList.add(2);
        // arrayList.add(2);
        // arrayList.add(2);
        // arrayList.add(2);
        // arrayList.add(3);
        int key = 1;
        mostFrequest(arrayList,key);
    }

    private static void mostFrequest(ArrayList<Integer> arrayList, int key) {
        int[] frr = new int[100];
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i)==key){
                frr[arrayList.get(i+1)-1]++;
            }
        }
        int max = Integer.MIN_VALUE;
        int max_index = 0;
        for (int i = 0; i < frr.length; i++) {
            if(max<frr[i]){
                max = frr[i];
                max_index = i;
            }
        }
        System.out.println(max_index+1);
    }
}
