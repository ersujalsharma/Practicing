package Graph;

import java.util.ArrayList;

class ShortestPathAlternatingColorLeetCode1129 {
    static class Edge{
        int src;
        int des;
        int color; // red --- 1 blue ---0
        public Edge(int src, int des, int color){
            this.src = src;
            this.des = des;
            this.color = color;
        }
        public String toString(){
            return this.src +" "+ this.des +" "+ this.color;
        }
    }
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        for(int i =0;i< graph.length;i++){
            graph[i] = new ArrayList<>();
        } 
        createGraph(graph,redEdges,blueEdges);
        for (int i = 0; i < graph.length; i++) {
            System.out.print(graph[i]);
        }
        return new int[1];
    }
    public void createGraph(ArrayList<Edge> graph[],int[][] redEdges,int[][] blueEdges){
        for(int i=0;i<redEdges.length;i++){
            graph[redEdges[i][0]].add(new Edge(redEdges[i][0],redEdges[i][1],1));
        }
        for(int i=0;i<blueEdges.length;i++){
            graph[blueEdges[i][0]].add(new Edge(blueEdges[i][0],blueEdges[i][1],0));
        }
    }
    public static void main(String[] args) {
        int n = 3;
        int[][] redEdges = {{0,1},{1,2}};
        int[][] blueEdges = {};
        ShortestPathAlternatingColorLeetCode1129 s = new ShortestPathAlternatingColorLeetCode1129();
        s.shortestAlternatingPaths(n, redEdges, blueEdges);
    }
}
