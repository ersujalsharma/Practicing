package GreedyAlgorithms;

import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthChainOfPairs {
    public static void main(String[] args) {
        int pairs[][] = {{5,24},{39,60},{5,28},{27,40},{50,90}};
        Arrays.sort(pairs,Comparator.comparingInt(o->o[1]));
        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < pairs[0].length; j++) {
                System.out.print(pairs[i][j]+" ");
            }
            System.out.println();
        }
        int ans = 0;
        int end = -1;
        for (int i = 0; i < pairs.length; i++) {
            if(pairs[i][0]>=end){
                end = pairs[i][1];
                ans++;
            }
        }
        System.out.println(ans);
    }
}
