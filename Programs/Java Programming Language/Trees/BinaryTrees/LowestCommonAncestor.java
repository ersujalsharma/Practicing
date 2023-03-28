package Trees.BinaryTrees;

import java.util.ArrayList;

public class LowestCommonAncestor {
    static class BinaryTree{
        static int index = -1;
        public Node buildTree(int[] nodes){
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
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        BinaryTree b = new BinaryTree();
        Node root = b.buildTree(nodes); 
        // Node lca = lowestCommonAncestor(root,6,3);
        Node lca = lcaInLinearTime(root,4,7);
        System.out.println(lca.data);
        
    }
    private static Node lcaInLinearTime(Node root, int n1, int n2) {
        if(root == null || root.data == n1 || root.data == n2) return root;
        Node lcaInLeft = lcaInLinearTime(root.left, n1, n2);
        Node lcaInRight = lcaInLinearTime(root.right, n1, n2);
        if(lcaInRight == null) return lcaInLeft;
        if(lcaInLeft == null) return lcaInRight;
        return root;
    }
    private static Node lowestCommonAncestor(Node root,int first,int second) {
        ArrayList<Node> path1 = new ArrayList<>();
        findPathOfNode(root,first,path1);
        ArrayList<Node> path2 = new ArrayList<>();
        findPathOfNode(root,second,path2);

        //
        int i = 0;
        for (; i < path1.size() && i<path2.size(); i++) {
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }
        Node lca = path1.get(i-1);
        System.out.println(path1);
        System.out.println(path2);
        return lca;
    }
    private static boolean findPathOfNode(Node root, int data, ArrayList<Node> path1) {
        if(root == null) return false;
        path1.add(root);
        if(root.data == data){
            return true;
        }
        boolean funleft = findPathOfNode(root.left, data, path1);
        boolean funright = findPathOfNode(root.right, data, path1);
        if(funleft || funright){
            return true;
        }
        path1.remove(path1.size()-1);
        return false;
    }
    
}
