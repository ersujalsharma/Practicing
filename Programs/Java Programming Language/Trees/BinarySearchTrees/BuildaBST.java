package Trees.BinarySearchTrees;

import java.util.ArrayList;
import java.util.List;

public class BuildaBST {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            left = null;
            right= null;
        }
    }
    public static void main(String[] args) {
        int[] values = {8,5,3,1,4,6,10,11,14};
        Node root = null;
        for(int i=0;i<values.length;i++){
            root = insert(root, values[i]);
        }
        inorder(root);
        int key = 1;
        boolean val = searchKey(root,key);
        System.out.println(val);
        root = deleteNode(root,key);
        inorder(root);
        printInRange(root, 5, 10);
        rootToLeafPaths(root,new ArrayList<>());
        System.out.println();
        Node root1 = mirror(root);
        inorder(root1);
    }
    public static Node mirror(Node root){
        if(root == null){
            return null;
        }
        Node left = mirror(root.right);
        Node right = mirror(root.left);
        root.left = left;
        root.right = right;
        return root;
    }
    public static void rootToLeafPaths(Node root,List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.data);
        if(root.left==null && root.right ==null){
            System.out.println(list);
            return;
        }
        rootToLeafPaths(root.left,list);
        rootToLeafPaths(root.right,list); 
        list.remove(list.size()-1);
    }
    public static void printInRange(Node root, int k1,int k2){
        if(root == null){
            return;
        }
        if(root.data >=k1 && root.data<=k2){
            printInRange(root.left, k1, k2);
            System.out.println(root.data+" ");
            printInRange(root.right, k1, k2);
        }
        else if(root.data<k1){
            printInRange(root.left, k1, k2);
        }
        else{
            printInRange(root.right, k1, k2);
        }
    }
    private static Node deleteNode(Node root, int key) {
        if(root.data<key){
            root.right = deleteNode(root.right, key);
        }
        else if(root.data>key){
            root.left = deleteNode(root.left, key);
        }
        else{
            if(root.left == null && root.right ==null){
                return null;
            }
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            Node IS = findInOrderSuccesse(root.right);
            root.data = IS.data;
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
    private static Node findInOrderSuccesse(Node root) {
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
    public static boolean searchKey(Node root,int key){
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        if(root.data<key){
            return searchKey(root.right, key);
        }
        else {
            return searchKey(root.left, key);
        }
    }
    private static void inorder(Node root) {
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
    public static Node insert(Node root,int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data>val){
            root.left = insert(root.left, val);
        }
        if(root.data<val){
            root.right = insert(root.right,val);
        }
        return root;
    }
   
}
