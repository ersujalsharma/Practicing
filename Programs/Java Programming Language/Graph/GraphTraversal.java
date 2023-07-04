package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GraphTraversal {
    static class Edge {
        int src, des;

        public Edge(int src, int des) {
            this.src = src;
            this.des = des;
        }

    }

    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge> graph[] = createGraph(v);
        bfs(graph);
        dfs(graph, 0, new boolean[graph.length]);
        boolean val = hasPath(graph, 0, 7, new boolean[graph.length]);
        System.out.println(val);
        boolean val2 = detectCycle(graph);
        System.out.println(val2);
        boolean val3 = detectCycleUsingBFS(graph);
        System.out.println(val3);
        boolean val4 = checkBipartile(graph);
        System.out.println(val4);
        boolean val5 = checkBipartileUsingProperties(graph);
        System.out.println(val5);
    }

    private static boolean checkBipartileUsingProperties(ArrayList<Edge>[] graph) {
        boolean isCyclic = detectCycle(graph);
        if(!isCyclic) return true;
        // create to check cycle is even odd
        // Even -> Bipartile
        boolean val = checkOddCycle(graph);
        if(val)  return true;
        return false;
    }

    // 1 Red
    // 2 Blue
    // 0 No Color

    private static boolean checkOddCycle(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        int[] depths = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!visited[i]){
                if(!checkOddCycleUtil(graph,1,i,visited,depths)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkOddCycleUtil(ArrayList<Edge>[] graph, int depth,int src, boolean[] visited, int[] depths) {
        visited[src] = true;
        depths[src] = depth;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if(!visited[e.des]){
                if(checkOddCycleUtil(graph, depth+1, e.des, visited, depths))
                    return true;
            }else if(depths[e.des] == depths[src]){
                  return true;
            }
        }
        return false;
    }

    private static boolean checkBipartile(ArrayList<Edge>[] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                q.add(i);
                color[i] = 0;
                while (!q.isEmpty()) {
                    int val = q.remove();
                    for (int j = 0; j < graph[val].size(); j++) {
                        Edge e = graph[val].get(j);
                        if (color[e.des] == -1) {
                            color[e.des] = color[val] == 0 ? 1 : 0;
                            q.add(e.des);
                        } else if (color[e.des] == color[val]) {
                            return false;
                        }
                        
                    }
                }
            }
        }

        return true;
    }

    private static boolean detectCycleUsingBFS(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (detectCycleUsingBFSUtil(graph, visited, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    static class Pair {
        int curr, par;

        public Pair(int curr, int par) {
            this.curr = curr;
            this.par = par;
        }
    }

    private static boolean detectCycleUsingBFSUtil(ArrayList<Edge>[] graph, boolean[] visited, int src) {
        Queue<Pair> q = new LinkedList<>();
        visited[src] = true;
        q.add(new Pair(src, -1));
        while (!q.isEmpty()) {
            int val = q.peek().curr;
            int par = q.peek().par;
            q.remove();
            for (int i = 0; i < graph[val].size(); i++) {
                Edge e = graph[val].get(i);
                if (!visited[e.des]) {
                    visited[e.des] = true;
                    q.add(new Pair(e.des, val));
                } else if (e.des != par) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i])
                if (detectCycleUtil(graph, visited, i, -1)) {
                    return true;
                }
        }
        return false;
    }

    private static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean[] visited, int cur, int par) {
        visited[cur] = true;
        for (int i = 0; i < graph[cur].size(); i++) {
            Edge e = graph[cur].get(i);
            if (!visited[e.des]) {
                if (detectCycleUtil(graph, visited, e.des, cur)) {
                    return true;
                }
            } else if (visited[e.des] && e.des != par) {
                return true;
            }
        }
        return false;
    }

    private static ArrayList<Edge>[] createGraph(int v) {
        ArrayList<Edge> graph[] = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        // graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        // graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        // graph[5].add(new Edge(5, 6));

        // graph[6].add(new Edge(6, 5));
        return graph;
    }

    private static boolean hasPath(ArrayList<Edge>[] graph, int src, int des, boolean[] visited) {
        // if neighbour has path then i have also
        if (src == des) {
            return true;
        }
        visited[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!visited[e.des] && hasPath(graph, e.des, des, visited)) {
                return true;
            }
        }
        return false;
    }

    private static void dfs(ArrayList<Edge>[] graph, int src, boolean[] visited) {
        System.out.print(src + " ");
        visited[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!visited[e.des]) {
                dfs(graph, e.des, visited);
            }
        }
    }

    private static void bfs(ArrayList<Edge>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        q.add(null);
        boolean visited[] = new boolean[graph.length];
        while (!q.isEmpty()) {
            if (q.peek() == null) {
                q.remove();
                System.out.println();
                if (q.isEmpty())
                    return;
                else {
                    q.add(null);
                }
            }
            int val = q.remove();
            if (visited[val] == false) {
                visited[val] = true;
                System.out.print(val + " ");
                for (int i = 0; i < graph[val].size(); i++) {
                    q.add(graph[val].get(i).des);
                }
            }
        }
    }
}
