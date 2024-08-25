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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();

        helper(root, dq);

        while (dq.size()>0){
            res.add(dq.getLast());
            dq.removeLast();
        }
        return res;
    }


    void helper (TreeNode node, Deque<Integer> list){

        if (node==null) return;

        list.addLast(node.val);

        helper(node.right, list);
        helper(node.left, list);
    }
}