public class SubTreeOfAnotherTree {
    static class BinaryTree {
        int index = -1;

        public Node buildTree(int[] nodes) {
            index++;
            if (nodes[index] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = new BinaryTree().buildTree(arr);
        int[] subarr = { 2, 3, -1, -1, 5, -1, -1 };
        Node subroot = new BinaryTree().buildTree(subarr);
        boolean ans = isSubtreeOrNot(root, subroot);
        System.out.println(ans);
    }

    private static boolean isSubtreeOrNot(SubTreeOfAnotherTree.Node root, SubTreeOfAnotherTree.Node subroot) {
        if(root==null){
            return false;
        }
        if (root.data == subroot.data) {
            if(isIdentical(root,subroot)) return true;
        }
        return isSubtreeOrNot(root.left, subroot) || isSubtreeOrNot(root.right, subroot);
    }

    private static boolean isIdentical(SubTreeOfAnotherTree.Node node, SubTreeOfAnotherTree.Node subroot) {
        if(node == null && subroot == null)
            return true;
        else if(node == null || subroot == null || node.data != subroot.data){
            return false;
        }
        if(!isIdentical(node.left, subroot.left)) return false;
        if(!isIdentical(node.right, subroot.right)) return false;
        return true;
    }
}
