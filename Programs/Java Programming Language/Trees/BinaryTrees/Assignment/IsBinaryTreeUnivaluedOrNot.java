package Trees.BinaryTrees.Assignment;

public class IsBinaryTreeUnivaluedOrNot {
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
        int nodes[] = {1,1,-1,-1,2,-1,-1};
        BinaryTree b = new BinaryTree();
        Node root = b.buildTree(nodes); 
        boolean value = isBinaryTreeUnivaluedOrNot(root);
        System.out.println(value);
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
}
