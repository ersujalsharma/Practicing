package Trees.BinaryTrees;

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
        int k = 3;
        BinaryTree b = new BinaryTree();
        Node root = b.buildTree(nodes); 
        KthlevelOrderUsingRecur(root, k,1);
    }
}
