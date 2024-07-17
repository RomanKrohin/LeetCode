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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        List<TreeNode> list = new ArrayList<>();
        Arrays.sort(to_delete);

        if (to_delete.length>0 && to_delete[0]!=root.val){
            list.add(root);
        }

        for (int i=to_delete.length-1; i>-1; i--){
            helper(root, new TreeNode(-1), to_delete[i], list);
        }


        return list;
    }

    public boolean helper (TreeNode root, TreeNode prev, int to_delete, List<TreeNode> list){
        if (root.val==to_delete){
            if (root.left!=null) list.add(root.left);
            if (root.right!=null) list.add(root.right);

            if (prev.right!=null && prev.right==root){
                prev.right=null;
            }

            if (prev.left!=null && prev.left==root){
                prev.left=null;
            }

            list.remove(root);
            return true;
        }

        if (root.left!=null && helper(root.left, root, to_delete, list)){
            return true;
        }

        if (root.right!=null && helper(root.right, root, to_delete, list)){
            return true;
        }

        return  false;
    };

}