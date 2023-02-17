package Queue.Assignments;

import java.util.PriorityQueue;

public class ConnectNRopesWithMinimumCost {
    public static void main(String[] args) {
        int len[] =  {4,3,2,6};
        int size = len.length;
        System.out.println("Total cost for connecting " + "ropes is"+minCost(len,size));
    }

    private static int minCost(int[] len, int size) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < len.length; i++) {
            pq.add(len[i]);
        }
        System.out.println( pq );
        return 0;
    }
}
