package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DirectedGraph {
    static class Edge {
        int src, des;

        public Edge(int src, int des) {
            this.src = src;
            this.des = des;
        }

    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge> graph[] = createGraph(v);
        boolean ans = detectCycleInDirectedGraph(graph);
        System.out.println(ans);
        topsort(graph); 
        topsortusingBFS(graph);
        System.out.println();
        printAllPath(graph,0,3,"");
    }

    private static void printAllPath(ArrayList<Edge>[] graph, int src, int dest, String path) {
        if(src == dest) {
            System.out.println(path+" "+dest);
            return;
        }
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            printAllPath(graph, e.des , dest, path+" "+src);
        }
    }

    private static void topsortusingBFS(ArrayList<Edge>[] graph) {
        int indegree[] = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();
        calcIndegree(graph,indegree);
        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int val = q.remove();
            System.out.print(val+" ");
            for (int i = 0; i < graph[val].size(); i++) {
                Edge e = graph[val].get(i);
                indegree[e.des]--;
                if(indegree[e.des]==0){
                    q.add(e.des);
                }
            }
        }
    }

    private static void calcIndegree(ArrayList<Edge>[] graph, int[] indegree) {
        for(int i=0;i<graph.length;i++){
            int v = i;
            for(int j=0;j<graph[v].size();j++){
                Edge e = graph[v].get(j);
                indegree[e.des]++;
            }
        }
    }

    private static void topsort(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if(!visited[i]){
                topsortUtil(graph,visited,i,s);
            }
        }
        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
    }

    private static void topsortUtil(ArrayList<Edge>[] graph, boolean[] visited, int curr, Stack<Integer> s) {
        visited[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.des]){
                topsortUtil(graph, visited, e.des, s);
            }
        }
        s.push(curr);
    }

    private static boolean detectCycleInDirectedGraph(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                if(detectCycleInDirectedGraphUtil(graph,visited,i,stack)){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean detectCycleInDirectedGraphUtil(ArrayList<Edge>[] graph, boolean[] visited, int curr, boolean[] stack) {
        visited[curr] = true;
        stack[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(stack[e.des]== true) return true;
            if(!visited[e.des]){
                if(detectCycleInDirectedGraphUtil(graph, visited, e.des, stack))
                    return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    private static ArrayList<Edge>[] createGraph(int v) {
        ArrayList<Edge>[] graph = new ArrayList[v];
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        // graph[0].add(new Edge(0, 2));
        // graph[1].add(new Edge(1, 0));
        // graph[2].add(new Edge(2,3));
        // graph[3].add(new Edge(3,0));

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0,2));
        graph[2].add(new Edge(2, 3));
        graph[1].add(new Edge(1,3));
        return graph;
    }
}
