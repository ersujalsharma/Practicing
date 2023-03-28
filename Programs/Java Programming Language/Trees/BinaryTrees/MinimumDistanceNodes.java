package Trees.BinaryTrees;

public class MinimumDistanceNodes {
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
        int n1 = 4;
        int n2 = 7;
        Node lca = lcaInLinearTime(root,4,7);
        int distance1 =  getPath(lca,n1);
        int distance2 =  getPath(lca,n2);
        System.out.println(distance1+distance2);
    }
    private static int getPath(Node lca, int n) {
        if(lca == null) return -1;
        if(lca.data == n) return 0;
        int left =  getPath(lca.left,n);
        int right = getPath(lca.right, n);
        if(left == -1 && right == -1){
            return -1;
        }
        else if(left==-1){
            return right+1;
        }
        else{
            return left+1;
        }
    }
    private static Node lcaInLinearTime(Node root, int n1, int n2) {
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }
        Node lcaInLeft = lcaInLinearTime(root.left, n1, n2);
        Node lcaInRight = lcaInLinearTime(root.right, n1, n2);
        if(lcaInRight == null) return lcaInLeft;
        if(lcaInLeft == null) return lcaInRight;
        return root;
    }
}
