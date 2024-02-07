package Graph.DSU;

import java.util.ArrayList;

public class DisjoinSetUnionByRank {
    static class DSU{
        int size;
        ArrayList<Integer> rank = new ArrayList<>();
        ArrayList<Integer> parent = new ArrayList<>();
        public DSU(int size){
            this.size = size;
            for(int i=0;i<=size;i++){
                rank.add(0);
                parent.add(i);
            }
        }
        public int findUltimateParent(int node){
            if(node == parent.get(node)){
                return node;
            }
            int ulp = findUltimateParent(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }
        public void unionByRank(int u,int v){
            int ulp_u = findUltimateParent(u);
            int ulp_v = findUltimateParent(v);
            if(ulp_u == ulp_v) return;
            if(rank.get(ulp_u)<rank.get(ulp_v)){
                parent.set(ulp_u, ulp_v);
            }
            else if(rank.get(ulp_v)<rank.get(ulp_u)){
                parent.set(ulp_v, ulp_u);
            }
            else{
                parent.set(ulp_v, ulp_u);
                rank.set(ulp_u, rank.get(ulp_u)+1);
            }
        }
    }
    public static void main(String[] args) {
        DSU dsu = new DSU(7);
        dsu.unionByRank(1, 2);
        dsu.unionByRank(2, 3);
        dsu.unionByRank(4, 5);
        dsu.unionByRank(6, 7);
        dsu.unionByRank(5, 6);
        if(dsu.findUltimateParent(0)==dsu.findUltimateParent(7)){
            System.out.println("Same");
        }
        else{
            System.out.println("Not Same");
        }
        dsu.unionByRank(3,7);
        if(dsu.findUltimateParent(3) == dsu.findUltimateParent(7)){
            System.out.println("Same");
        }
        else{
            System.out.println("Not Same");
        }
    }
}
