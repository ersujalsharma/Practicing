package Heaps;

import java.util.PriorityQueue;

/**
 * ConnectNRopes
 */
public class ConnectNRopes {

    public static void main(String[] args) {
        int arr[] = {2,3,3,4,6};
        int ans =  help(arr);
        System.out.println(ans);
    }

    private static int help(int[] arr) {
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        while(pq.size()>1){
            int sum = pq.remove()+pq.remove();
            count+=sum;
            pq.add(sum);
        }
        return count;
    }
    
}