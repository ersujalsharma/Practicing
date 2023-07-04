package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijksrtasAlgorithm {
    static class Edge {
        int src, des, wt;

        public Edge(int src, int des, int wt) {
            this.src = src;
            this.des = des;
            this.wt = wt;
        }
    }

    static class Pair implements Comparable<Pair>{
        int node;
        int path;
        public Pair(int n,int path){
            this.node = n;
            this.path = path;
        }
        @Override
        public int compareTo(Pair o) {
            // TODO Auto-generated method stub
            return this.path-o.path;
        }
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        int src = 0;
        dijkstra(graph,src);
        bellmanFord(graph);
    }

    private static void bellmanFord(ArrayList<Edge>[] graph) {
        int distance[] = new int[graph.length];
        distance[0] = 0;
        for(int i=0;i<distance.length;i++){
            distance[i] = Integer.MAX_VALUE;
        }
        int V = graph.length;
        for (int i = 0; i < V-1; i++) {
            // find all edges 
            for (int j = 0; j < graph.length; j++) {
                for (int j2 = 0; j2 < graph[j].size(); j2++) {
                    Edge e = graph[j].get(j2);
                    int u = e.src;
                    int v = e.des;
                    int wt = e.wt;
                    if(distance[u]!=Integer.MAX_VALUE && distance[v]>distance[u]+wt){
                        distance[v] = distance[u]+wt;
                    }
                }
            }
        }
        for (int i = 0; i < distance.length; i++) {
            System.out.print(distance[i]+" ");
        }
    }

    private static void dijkstra(ArrayList<Edge>[] graph, int src) {
        int[] distance = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(i!=src){
                distance[i] = Integer.MAX_VALUE;
            }
        }
        boolean []visited = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        while(!pq.isEmpty()){
            Pair cur = pq.remove();
            if(!visited[cur.node]){
                visited[cur.node] = true;
                for (int i = 0; i < graph[cur.node].size(); i++) {
                    Edge e = graph[cur.node].get(i);
                    int u = e.src;
                    int v = e.des;
                    int wt = e.wt;
                    if(distance[u]+wt < distance[v]){
                        distance[v] = distance[u]+wt;
                        pq.add(new Pair(v,distance[v]));
                    }
                }
            }
        }
        for (int dis : distance) {
            System.out.print(dis+" ");
        }
    }

    private static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }
}
