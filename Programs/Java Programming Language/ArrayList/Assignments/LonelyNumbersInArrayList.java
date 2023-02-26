package ArrayList.Assignments;

import java.util.ArrayList;
import java.util.Collections;

public class LonelyNumbersInArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(6);
        arrayList.add(5);
        arrayList.add(8);
        findLonelyNumbers(arrayList);
    }

    private static void findLonelyNumbers(ArrayList<Integer> arrayList) {
        Collections.sort(arrayList);
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i < arrayList.size() - 1; i++) {
            if (arrayList.get(i - 1) + 1 < arrayList.get(i) && arrayList.get(i) + 1 < arrayList.get(i + 1)) {
                arr.add(arrayList.get(i));
            }
        }
        if (arrayList.size() == 1) {
            arr.add(arrayList.get(0));
        }
        if (arrayList.size() > 1) {
            if (arrayList.get(0) + 1 < arrayList.get(1)) {
                arr.add(arrayList.get(0));
            }
            if (arrayList.get(arrayList.size() - 2) + 1 < arrayList.get(arrayList.size() - 1)) {
                arr.add(arrayList.get(arrayList.size() - 1));
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i)+" ");
        }
    }
}
