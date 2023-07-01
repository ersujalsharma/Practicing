package Graph;

import java.util.ArrayList;

public class ImplementationUsingAdjacencyList {
    /*
     *       (5)
     *     0------1
     *       (1) / \ (3)
     *          /   \
     *         2-----3
     *         |  (1)
     *         |
     *      (2)|
     *         4
     *
     */
    static class Edge {
        int src, des, weight;

        public Edge(int src, int des, int weight) {
            this.src = src;
            this.des = des;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        for (int i=0;i<v;i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));
        graph[4].add(new Edge(4, 2, 2));
        
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                System.out.println(graph[i].get(j).src+"--"+graph[i].get(j).weight+"-->"+graph[i].get(j).des);
            }
        }

    }
}
