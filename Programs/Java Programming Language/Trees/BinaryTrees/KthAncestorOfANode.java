package Trees.BinaryTrees;

public class KthAncestorOfANode {
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
        int k = 2;
        int n = 4;
        kthAncestorOfANode(root,n,k);
    }
    private static int kthAncestorOfANode(Node root, int n, int k) {
        if(root == null) return -1;
        if(root.data == n){
            return 0;
        }
        int left = kthAncestorOfANode(root.left, n, k);
        int right = kthAncestorOfANode(root.right, n, k);
        if(left == -1 && right == -1) return -1;
        int max = Math.max(left, right);
        if(max+1 == k){
            System.out.println(root.data);
        }
        return max+1;
    }
}
