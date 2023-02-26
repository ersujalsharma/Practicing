package Trees.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreesPreOrder {
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
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1,6};
        BinaryTree b = new BinaryTree();
        Node root = b.buildTree(nodes); 
        // preOrder(root);
        // inOrder(root);
        // postOrder(root);
        // levelOrder(root);
        // int ans = heightOfATree(root);
        int ans = sumOfNodes(root);
        // int ans = countNodes(root);
        System.out.println(ans);
    }


// 




    private static int sumOfNodes(Node root) {
        if(root == null)
            return 0;
        int leftSum = sumOfNodes(root.left);
        int rightSum =  sumOfNodes(root.right);
        return leftSum+rightSum+root.data;
    }


    private static int countNodes(Node root) {
        if(root==null){
            return 0;
        }
        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);
        return leftNodes+rightNodes+1; 
    }


    private static int heightOfATree(Node root) {
        if(root ==null){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int heightOfLeft = heightOfATree(root.left);
        int heightOfRight = heightOfATree(root.right);
        max = Math.max(heightOfLeft, heightOfRight);
        return max+1;
    }


    private static void levelOrder(Node root) {
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
                if(queue.isEmpty()){
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
    private static void postOrder(Node root) {
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }
    private static void inOrder(Node root) {
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }
    private static void preOrder(Node root) {
        if(root==null){
            System.out.print(-1+" ");
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
}
