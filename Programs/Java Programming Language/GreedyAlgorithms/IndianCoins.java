package GreedyAlgorithms;

import java.util.Arrays;

public class IndianCoins {
    public static void main(String[] args) {
        int Notes[] = {1,5,2,10,20,50,100,500,2000};
        Arrays.sort(Notes);
        int val = 1059;
        int ans = 0;
        for (int i = Notes.length-1; i >= 0; i--) {
            if(val/Notes[i]>0){
                ans += val/Notes[i];
                System.out.println(Notes[i]+"*"+val/Notes[i]+" ");
                val=val%Notes[i];
            }
        }
        System.out.println(ans);
    }
}
