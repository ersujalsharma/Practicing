package Trees.BinarySearchTrees;
class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
public class RangeSumOfBST {
        public static int sum;
        public int rangeSumBST(TreeNode root, int low, int high) {
            if(root == null){
                return 0;
            }
            if(low<=root.val &&  root.val<=high){
                System.out.println(root.val);
                sum+=root.val;
            }
            if(root.val>low)
                rangeSumBST(root.left,low,high);
            if(root.val<high)
                rangeSumBST(root.right,low,high);
            return sum;
        }
}
