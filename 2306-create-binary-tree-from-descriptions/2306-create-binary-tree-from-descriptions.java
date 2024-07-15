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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            int childVal = desc[1];
            boolean isLeft = desc[2] == 1;

            TreeNode parentNode = nodeMap.computeIfAbsent(parentVal, k -> new TreeNode(k));
            TreeNode childNode = nodeMap.computeIfAbsent(childVal, k -> new TreeNode(k));

            if (isLeft) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

            children.add(childVal);
        }

        TreeNode root = null;
        for (int[] desc : descriptions) {
            if (!children.contains(desc[0])) {
                root = nodeMap.get(desc[0]);
                break;
            }
        }

        return root;
    }
}