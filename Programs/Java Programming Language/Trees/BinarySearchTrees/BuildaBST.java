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
        // int[] values = {8,5,3,1,4,6,10,11,14};
        // Node root = null;
        // for(int i=0;i<values.length;i++){
        //     root = insert(root, values[i]);
        // }
        // // inorder(root);
        // // int key = 1;
        // // boolean val = searchKey(root,key);
        // // System.out.println(val);
        // // root = deleteNode(root,key);
        // // inorder(root);
        // // printInRange(root, 5, 10);
        // // rootToLeafPaths(root,new ArrayList<>());
        // // System.out.println();
        // Node root1 = mirror(root);
        // int[] arr = {3,5,6,8,10,11,12};
        // Node root2 = sortedBalancedBST(arr,0,arr.length-1);
        // inorder(root2);
        // largestBST(root2);
        // System.out.println(maxBST);
        int[] values1 = {2,1,4};
        Node root1 = null;
        for(int i=0;i<values1.length;i++){
            root1 = insert(root1, values1[i]);
        }
        int[] values2 = {5,3,7};
        Node root2 = null;
        for(int i=0;i<values2.length;i++){
            root2 = insert(root2, values2[i]);
        }
        Node merged = merge2Bst(root1, root2);
        inorder(merged);
    }
    public static Node merge2Bst(Node root1,Node root2){
        List<Integer> list1 = new ArrayList<>();
        bstToSortedList(root1,list1);
        System.out.println(list1);
        List<Integer> list2 = new ArrayList<>();
        bstToSortedList(root2,list2);
        System.out.println(list2);

        List<Integer> mergedArray = new ArrayList<>();
        int i=0,j=0;
        while(i<list1.size() && j<list2.size()){
            if(list1.get(i)<=list2.get(j)){
                mergedArray.add(list1.get(i));
                i++;
            }
            else{
                mergedArray.add(list2.get(j));
                j++;
            }
        }
        while(i<list1.size()){
            mergedArray.add(list1.get(i));
            i++;
        }
        while(j<list2.size()){
            mergedArray.add(list2.get(j));
            j++;
        }

        System.out.println(mergedArray);
        return sortedToBST(mergedArray, 0, mergedArray.size()-1);
        // return sortedToBST(mergedArray, 0, mergedArray.size()-1);
    } 
    private static void bstToSortedList(Node root,List<Integer> list) {
        if(root == null) return;
        bstToSortedList(root.left,list);
        list.add(root.data);
        bstToSortedList(root.right,list);
     }
    public static Node sortedToBST(List<Integer> arr, int i, int j){
        if(i>j){
            return null;
        }
        int mid = i+(j-i)/2;
        Node root = new Node(arr.get(mid));
        root.left = sortedToBST(arr,i, mid-1);
        root.right = sortedToBST(arr, mid+1, j);
        return root;
    }

    

    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;
        public Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
        
    }
    private static Info largestBST(Node root) {
        if(root == null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        int size = leftInfo.size+rightInfo.size+1;
        int min = Math.min(root.data,Math.min(leftInfo.min,rightInfo.min));
        int max = Math.max(root.data,Math.max(leftInfo.max,rightInfo.max));
        if(root.data <=leftInfo.max || root.data>=rightInfo.min){
            return new Info(false, size, min, max);
        }
        if(leftInfo.isBST && rightInfo.isBST){
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }
        return new Info(false, size, min, max);
    }
    public static int maxBST = 0;

    public static Node sortedBalancedBST(int[] arr, int i, int j){
        if(i>j){
            return null;
        }
        int mid = i+(j-i)/2;
        Node root = new Node(arr[mid]);
        root.left = sortedBalancedBST(arr,i, mid-1);
        root.right = sortedBalancedBST(arr, mid+1, j);
        return root;
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
