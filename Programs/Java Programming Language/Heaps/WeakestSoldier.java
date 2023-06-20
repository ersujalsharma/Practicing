package Heaps;

import java.util.PriorityQueue;

public class WeakestSoldier {

    static class Row implements Comparable<Row>{
        int numberOfSoldiers;
        int index;
        public Row(int numberOfSoldiers, int index) {
            this.numberOfSoldiers = numberOfSoldiers;
            this.index = index;
        }
        @Override
        public int compareTo(Row o) {
            if(this.numberOfSoldiers==o.numberOfSoldiers){
                return this.index-o.index;
            }
            return this.numberOfSoldiers-o.numberOfSoldiers;
        }
    }
    public static void main(String[] args) {
        int arr[][] = {
            {1,0,0,0},
            {1,1,1,1},
            {1,0,0,0},
            {1,0,0,0}
        };
        PriorityQueue<Row> pq = new PriorityQueue<>();
        int k = 2;
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr[0].length; j++) {
                count+= arr[i][j];
            }
            pq.add(new Row(count,i));
        }
        for(int i=0;i<k;i++){
            System.out.println("R"+pq.remove().index);
        }
    }
}
