package Trees.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class KthLevelTree {
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
        int k = 3;
        BinaryTree b = new BinaryTree();
        Node root = b.buildTree(nodes); 
        KthlevelOrderUsingRecur(root, k,1);
    }
    private static void KthlevelOrderUsingRecur(Node root, int k,int level) {
        if(root == null){
            return;
        }
        if(level == k){
            System.out.println(root.data);
            return;
        }
        KthlevelOrderUsingRecur(root.left, k, level+1);
        KthlevelOrderUsingRecur(root.right, k,level+1);
    }
    public static void KthlevelOrder(Node root,int k){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int level = 1;
        while(!q.isEmpty()){
            Node currentNode = q.remove();
            if(currentNode==null){
                if(q.isEmpty() || q.peek() == null){
                    break;
                }
                q.add(null);
                level++;
            }
            else{
                if(level == k){
                    System.out.println(currentNode.data);
                }
                if(currentNode.left !=null){
                    q.add(currentNode.left);
                }
                if(currentNode.right!=null){
                    q.add(currentNode.right);
                }
            }
        }
    }
}
