package GreedyAlgorithms;

import java.util.Arrays;
import java.util.Collections;

public class ChocolaProblem {
    public static void main(String[] args) {
        Integer hrcuts[] = {4,1,2};
        Integer vrcuts[] = {2,1,3,1,4};
        Arrays.sort(hrcuts,Collections.reverseOrder());
        Arrays.sort(vrcuts,Collections.reverseOrder());
        int hp=1,vp=1,h=0,v=0;
        int cost = 0;
        while(h<hrcuts.length && v<vrcuts.length){
            if(hrcuts[h]<vrcuts[v]){ // vertical cut
                cost += hp*vrcuts[v];
                v++;
                vp++;
            }
            else{
                cost += vp*hrcuts[h];
                h++;
                hp++;
            }
        }
        while(h<hrcuts.length){
            cost+=hrcuts[h]*vp;
            hp++;
            h++;
        }
        while(v<vrcuts.length){
            cost+=vrcuts[v]*hp;
            vp++;
            v++;
        }
        System.out.println(cost);
    }
}
