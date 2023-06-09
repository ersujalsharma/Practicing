package Trees.BinaryTrees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TopViewOfAtree {
    static class BinaryTree{
        static int index = -1;
        public static Node buildTree(int[] nodes){
            index++;
            if(nodes[index]==-1){
                return null;
            }
            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,4,-1,-1,6,-1,-1};
        BinaryTree b = new BinaryTree();
        Node root = b.buildTree(nodes); 
        topView(root);
    }
    static class Info{
        int hd;
        Node node;
        public Info(int hd,Node node){
            this.hd = hd;
            this.node = node;
        }
    }
    private static void topView(TopViewOfAtree.Node root) {
        Queue<Info> q = new LinkedList<>();
        Map<Integer,Node> map = new HashMap<>();
        int min =0 , max=0;
        q.add(new Info(0, root));
        q.add(null);
        while (!q.isEmpty()) {
            Info current = q.remove();
            if(current == null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }else{
            if(!map.containsKey(current.hd)){
                map.put(current.hd, current.node);
            }
            if(current.node.left !=null){
                q.add(new Info(current.hd-1, current.node.left));
                min = Math.min(min, current.hd-1);
            }
            if(current.node.right !=null){
                q.add(new Info(current.hd+1, current.node.right));
                max = Math.max(max, current.hd+1);
            }
        }

        }
        for (int i = min; i <= max; i++) {
            System.out.println(map.get(i).data);
        }
    }
}
