package ArrayList.Assignments;

import java.util.ArrayList;

/**
 * BeautifulArrayList
 */
public class BeautifulArrayList {

    public static void main(String[] args) {
        int n = 4;
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        for(int i=2;i<=n;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(Integer e:arrayList){
                if(2*e<=n) temp.add(e*2);
            }
            for (Integer e:arrayList) {
                if(2*e-1<=n) temp.add(e*2-1);
            }
            arrayList = temp;
        }
        for (Integer integer : arrayList) {
            System.out.print(integer +" ");
        }

    }
}