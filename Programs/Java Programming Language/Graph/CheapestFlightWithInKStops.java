package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class CheapestFlightWithInKStops {
    static class Edge{
        int src;
        int des;
        int cost;
        public Edge(int src, int des, int cost) {
            this.src = src;
            this.des = des;
            this.cost = cost;
        }
    }
    static class Info{
        int vertex;
        int cost;
        int stops;
        public Info(int vertex, int cost, int stops) {
            this.vertex = vertex;
            this.cost = cost;
            this.stops = stops;
        }
        
    }
    public static void main(String[] args) {
        int n = 4;
        int flights[][] = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0, des = 3, k=1;
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights,graph);
        findCheapestFlight(graph,src,des,k);
    }
    private static void findCheapestFlight(ArrayList<Edge>[] graph, int src, int des, int k) {
        Queue<Info> q = new ArrayDeque<>();
        int distance[] = new int[graph.length];
        for(int i=0;i<distance.length;i++){
            if(src!=i){
                distance[i] = Integer.MAX_VALUE;
            }
        }
        q.add(new Info(src, 0, 0));
        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr.stops>k){
                break;
            }
            for(int i=0;i<graph[curr.vertex].size();i++){
                Edge e = graph[curr.vertex].get(i);
                if(distance[e.src]!=Integer.MAX_VALUE &&curr.cost+e.cost<distance[e.des] && curr.stops<=k){
                    distance[e.des] = curr.cost+e.cost;
                }
                q.add(new Info(e.des, distance[e.des], curr.stops+1));
            }
        }
        if(distance[des]==Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else
            System.out.println(distance[des]);
    }
    private static void createGraph(int[][] flights, ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < flights.length; i++) {
            graph[flights[i][0]].add(new Edge(flights[i][0], flights[i][1], flights[i][2]));
        }
    }
}
