package ArrayList.Assignments;

import java.util.ArrayList;

public class MonotonicArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(6);
        arrayList.add(5);
        arrayList.add(4);
        arrayList.add(4);
        // boolean val = checkArrayListIsMonotonicOrNot(arrayList);
        boolean val = isMonotonic(arrayList);
        System.out.println(val);
    }

    private static boolean isMonotonic(ArrayList<Integer> arrayList) {
        boolean inc = true;
        boolean dec = true;
        for (int i = 0; i < arrayList.size()-1; i++) {
            if(arrayList.get(i)<arrayList.get(i+1)){
                inc = false;
            }
            if(arrayList.get(i)>arrayList.get(i+1)){
                dec = false;
            }
        }
        return inc || dec;
    }

    private static boolean checkArrayListIsMonotonicOrNot(ArrayList<Integer> arr) {
        if(checkMonitoneIncreasing(arr) || checkMonitoneDecreasing(arr)){
            return true;
        }
        return false;
    }

    private static boolean checkMonitoneDecreasing(ArrayList<Integer> arr) {
        boolean ans = false;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size(); j++) {
                if(i<=j){
                    if(arr.get(i)<=arr.get(j))
                        ans = true;
                    else{
                        return false;
                    }
                }
            }
        }
        return ans;
    }

    private static boolean checkMonitoneIncreasing(ArrayList<Integer> arr) {
        boolean ans = false;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size(); j++) {
                if(i<=j){
                    if(arr.get(i)>=arr.get(j)){
                        ans = true;
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        return ans;
    }
}
