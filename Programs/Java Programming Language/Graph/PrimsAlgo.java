package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Set;

public class PrimsAlgo {
    static class Edge {
        int src, des, wt;

        public Edge(int src, int des, int wt) {
            this.src = src;
            this.des = des;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge> graph[] = createGraph(v);
        ArrayList<Integer> ans = findMST(graph);
        System.out.println(ans);
    }

    static class Pair implements Comparable<Pair>{
        int vertex;
        int cost;
        public Pair(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
        @Override
        public int compareTo(Pair o) {
            // TODO Auto-generated method stub
            return this.cost-o.cost;
        }
    }

    private static ArrayList<Integer> findMST(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        ArrayList<Integer> al = new ArrayList<>(); 
        PriorityQueue<Pair>  pq = new PriorityQueue<>();
        pq.add(new Pair(0,0));
        int finalcost = 0;
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!visited[curr.vertex]){
                visited[curr.vertex] = true;
                al.add(curr.vertex);
                al.add(curr.cost);
                finalcost += curr.cost;
                for (int i = 0; i < graph[curr.vertex].size(); i++) {
                    Edge e = graph[curr.vertex].get(i);
                    pq.add(new Pair(e.des,e.wt));
                }
            }
        }
        System.out.println(finalcost);
        return al;
    }

    private static ArrayList<Edge>[] createGraph(int v) {
        ArrayList<Edge>[] graph = new ArrayList[v];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));
        graph[2].add(new Edge(0, 2, 15));
        graph[2].add(new Edge(2, 3, 50));
        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
        return graph;
    }
}
