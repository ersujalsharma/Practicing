package Heaps;

import java.util.PriorityQueue;

public class NearByCars {
    public static void main(String[] args) {
        int arr[][] = {{3,3},{5,-1},{-2,4}};
        int k = 2;
        nearbycars(arr,k);
    }
    static class Point implements Comparable<Point>{
        int x;
        int y;
        int disSq;
        int index;
        public Point(int x, int y, int disSq, int index) {
            this.x = x;
            this.y = y;
            this.disSq = disSq;
            this.index = index;
        }
        @Override
        public int compareTo(Point o) {
            // TODO Auto-generated method stub
            return this.disSq-o.disSq;
        }
        
    }

    private static void nearbycars(int[][] arr, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            int disSq = arr[i][0]*arr[i][0] + arr[i][1]*arr[i][1];
            pq.add(new Point(arr[i][0], arr[i][1], disSq , i));
        }
        for (int i = 0; i < k; i++) {
            System.out.println("C"+pq.remove().index);
        }
    }
}
