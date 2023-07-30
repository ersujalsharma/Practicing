package Graph.DSU;

import java.util.ArrayList;
import java.util.Collections;

public class KrukshalsAlgorithm {
    static class Edge implements Comparable<Edge>{
        int src,des,cost;

        public Edge(int src, int des, int cost) {
            this.src = src;
            this.des = des;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost-o.cost;
        }
    }
    static void createGraph(ArrayList<Edge> graph){
        graph.add(new Edge(0,1,10));
        graph.add(new Edge(0,2,15));
        graph.add(new Edge(0,3,30));
        graph.add(new Edge(1,3,40));
        graph.add(new Edge(2,3,50));
    }
    static int n = 4;
    static int par[] = new int[n];
    static int rank[] = new int[n];
    public static void init(){
        for(int i=0;i<par.length;i++){
            par[i] = i;
        }
    }
    public static int find(int x){
        if(par[x] == x){
            return x;
        }
        return par[x] = find(par[x]);
    }
    public static void union(int a,int b){
        int parA = find(a);
        int parB = find(b);
        if(rank[parA] == rank[parB]){
            par[parB] = parA;
            rank[parA]++;
        }
        else if(rank[parA]<rank[parB]){
            par[parA] = parB;
        }
        else{
            par[parB] = parA;
        }
    }
    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        krushkalsMST(edges,v);
    }
    private static void krushkalsMST(ArrayList<Edge> edges, int v) {
        init();
        Collections.sort(edges);
        int mstcost = 0;
        int count = 0;
        for(int i =0;count<v-1;i++){
            Edge e = edges.get(i);
            int parA = find(e.src);
            int parB = find(e.des);
            if(parA != parB){
                union(e.src,e.des);
                mstcost+=e.cost;
                count++;
            }
        }
        System.out.println(mstcost);

    }
}
