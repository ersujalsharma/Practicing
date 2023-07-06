package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ConnectingCities {
    static class Edge{
        int src, des,cost;

        public Edge(int src, int des, int cost) {
            this.src = src;
            this.des = des;
            this.cost = cost;
        }
        
    }
    public static void main(String[] args) {
        int cities[][] = {
            {0,1,2,3,4},
            {1,0,5,0,7},
            {2,5,0,6,0},
            {3,0,6,0,0},
            {4,7,0,0,0}
        };
        ArrayList<Edge> graph[] = new ArrayList[cities.length];
        createGraph(graph,cities);
        // for (int i = 0; i < graph.length; i++) {
        //     for (int j = 0; j < graph[i].size(); j++) {
        //         System.out.println(graph[i].get(j).src+"--->"+graph[i].get(j).des+"--->"+graph[i].get(j).cost);
        //     }
        // }
        connectCitiesWithMinimumCost(graph);
    }
    static class Pair implements Comparable<Pair>{
        int src,cost;

        public Pair(int src, int cost) {
            this.src = src;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair o) {
            // TODO Auto-generated method stub
            return this.cost-o.cost;
        }
        
    }
    private static void connectCitiesWithMinimumCost(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        PriorityQueue<Pair> pq =new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int finalcost=0;
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!visited[curr.src]){
                visited[curr.src] = true;
                finalcost+=curr.cost;
                for (int i = 0; i < graph[curr.src].size(); i++) {
                    Edge e = graph[curr.src].get(i);
                    if(!visited[e.des])
                        pq.add(new Pair(e.des,e.cost));
                }
            }
        }
        System.out.println(finalcost);
    }
    private static void createGraph(ArrayList<Edge>[] graph, int[][] cities) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<cities.length;i++){
            for(int j=0;j<cities.length;j++){
                if(cities[i][j] != 0){
                    graph[i].add(new Edge(i, j, cities[i][j]));
                }
            }
        }
    }
}
