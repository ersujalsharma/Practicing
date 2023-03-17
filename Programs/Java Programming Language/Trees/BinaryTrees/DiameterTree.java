import java.util.LinkedList;
import java.util.Queue;

public class DiameterTree {
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
        int[] arr = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = BinaryTree.buildTree(arr);
        levelOrder(root);
        infor inf = diameter(root);
        System.out.println(inf.diameter);
    }
    static class infor{
        int diameter;
        int height;
        
        public infor() {
        }

        public infor(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
        
    }
    private static infor diameter(DiameterTree.Node root) {
        if(root == null){
            return new infor();
        }
        infor leftInfo = diameter(root.left);
        infor rightInfo = diameter(root.right);
        int finaldiameter = Math.max(leftInfo.diameter,Math.max(rightInfo.diameter,leftInfo.height+rightInfo.height+1));
        int finalheight = Math.max(leftInfo.height,rightInfo.height)+1;
        return new infor(finaldiameter,finalheight);
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
