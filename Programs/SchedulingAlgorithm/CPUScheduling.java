package Programs.SchedulingAlgorithm;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CPUScheduling {
    static class PCB{
        String name;
        int arrivalTime;
        int burstTime;
        public PCB(String name, int arrivalTime, int burstTime) {
            this.name = name;
            this.arrivalTime = arrivalTime;
            this.burstTime = burstTime;
        }
    }
    public static void main(String[] args) {
        PCB arr[] = new PCB[4];
        arr[0] = new PCB("P1",0,8);
        arr[1] = new PCB("P2",7,4);
        arr[2] = new PCB("P3",2,9);
        arr[3] = new PCB("P4",3,3);
        applyFCFS(arr);
        applySJF(arr);
    }
    
    private static void applySJF(PCB[] arr) {
        int time = 0;
        int processes = arr.length;
        boolean visited[] = new boolean[arr.length];
        PriorityQueue<PCB> pq = new PriorityQueue<>((a,b)->a.burstTime-b.burstTime);
        while(processes>0){
            if(!pq.isEmpty()){
                System.out.print(pq.peek().name);
                time += pq.poll().burstTime;
            }
            for(int i=0;i<arr.length;i++){
                if(arr[i].arrivalTime<=time && !visited[i]){
                    pq.add(arr[i]);
                    visited[i] = true;
                }
            }
            time++;
        }
        System.out.println(pq);
    }

    private static void applyFCFS(PCB[] arr) {
        Arrays.sort(arr,(a,b)->a.arrivalTime-b.arrivalTime);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i].name+" ");
        }
    }
}
