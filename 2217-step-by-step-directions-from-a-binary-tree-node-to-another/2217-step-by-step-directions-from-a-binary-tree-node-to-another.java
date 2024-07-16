/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {

        StringBuilder start_str = new StringBuilder();
        StringBuilder dest_str = new StringBuilder();

        findPath(root, destValue, dest_str);
        findPath(root, startValue, start_str);

        start_str.reverse();
        dest_str.reverse();
        while (start_str.length()>0 && dest_str.length()>0 && start_str.charAt(0) == dest_str.charAt(0)){
            start_str.deleteCharAt(0);
            dest_str.deleteCharAt(0);
        }

        return "U".repeat(start_str.length()) + dest_str.toString();
    }

    private boolean findPath(TreeNode node, int destValue, StringBuilder sb){

        if (node.val==destValue){
            return true;
        }

        if (node.left!=null && findPath(node.left, destValue, sb)){
            sb.append("L");
            return true;
        }

        if (node.right!=null && findPath(node.right, destValue, sb)){
            sb.append("R");
            return true;
        }

        return false;
    }
}