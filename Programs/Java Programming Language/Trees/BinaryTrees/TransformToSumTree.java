package Trees.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class TransformToSumTree {
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
        transformToSumTree(root);
        levelOrder(root);
    }
    private static int transformToSumTree(Node root) {
        if(root == null){
            return 0;
        }
        int lst = transformToSumTree(root.left);
        int rst = transformToSumTree(root.right);
        int temp = root.data;
        root.data = lst+rst;
        return temp+root.data;
    }
    public static void levelOrder(Node root) {
        if(root==null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            Node currentNode = queue.remove();
            if(currentNode==null){
                System.out.println();
                if(queue.isEmpty() || queue.peek() ==null){
                    break;
                }
                else{
                    queue.add(null);
                }
            }
            else{
                System.out.print(currentNode.data+" ");
                if(currentNode.left!=null)
                queue.add(currentNode.left);
                if(currentNode.right!=null);
                queue.add(currentNode.right);
            }
        }
    }
}
