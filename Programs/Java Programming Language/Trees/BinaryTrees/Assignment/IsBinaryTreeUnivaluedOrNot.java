package Trees.BinaryTrees.Assignment;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class IsBinaryTreeUnivaluedOrNot {
    public static HashMap<String,Integer> hashmap ;
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
        int nodes[] = {1,4,3,-1,-1,-1,3,4,3,-1,-1,-1,3,-1,-1};
        BinaryTree b = new BinaryTree();
        Node root = b.buildTree(nodes); 
        boolean value = isBinaryTreeUnivaluedOrNot(root);
        // System.out.println(value);
        // Node root2 = Mirror(root);
        // levelOrder(root2);   
        Node newnode = deleteLeafNodeWithX(root, 3);
        // levelOrder(newnode);
        printAllDupicates(root);
    }
    private static boolean isBinaryTreeUnivaluedOrNot(Node root) {
        if(root == null){
            return true;
        }
        if(root.left!=null && root.left.data != root.data){
            return false;
        }
        if(root.right!=null && root.right.data != root.data){
            return false;
        }
        return isBinaryTreeUnivaluedOrNot(root.left) && isBinaryTreeUnivaluedOrNot(root.right);
    }
    public static Node Mirror(Node node){
        if(node == null){
            return node;
        }
        Node left  = Mirror(node.left);
        Node right = Mirror(node.right);
        node.left = right;
        node.right = left;
        return node; 
    }
    public static Node deleteLeafNodeWithX(Node root,int X){
           if(root == null){
            return root;
           }
           root.left = deleteLeafNodeWithX(root.left, X);
           root.right = deleteLeafNodeWithX(root.right, X);
           if(root.left == null && root.right==null && root.data == X){
                return  null;
           }
           return root;
    }
    public static void printAllDupicates(Node root){
        hashmap = new HashMap<>();
        inorder(root);
    }
    private static String inorder(Node root) {
        if(root == null){
            return "";
        }
        String str = "(";
        str+=inorder(root.left);
        str+=Integer.toString(root.data);
        str+=inorder(root.right);
        str+=")";
        if(hashmap.containsKey(str)){
            if(hashmap.get(str)==1){
                System.out.println(root.data+" ");
            }
            else{
                hashmap.put(str, hashmap.get(str)+1);
            }
        }
        else{
            hashmap.put(str, 1);
        }
        return str;
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
