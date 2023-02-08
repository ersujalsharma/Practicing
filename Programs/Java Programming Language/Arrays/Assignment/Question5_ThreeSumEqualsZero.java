package Arrays.Assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public class Question5_ThreeSumEqualsZero {
    public static void main(String[] args) {
        int[] num = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < num.length; i++) {
            for (int j = i+1; j < num.length; j++) {
                for (int k = j+1; k < num.length; k++) {
                    if(num[i]+num[j]+num[k] == 0){
                        List<Integer> triplet = new ArrayList<Integer>();
                        triplet.add(num[i]);
                        triplet.add(num[j]);
                        triplet.add(num[k]);
                        Collections.sort(triplet);
                        result.add(triplet);
                    }
                }
            }
        }
        result = new ArrayList<List<Integer>>(new LinkedHashSet<List<Integer>>(result));
        System.out.println(result);

    }
}
