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
    public int countPairs(TreeNode root, int distance) {
        if (root == null) return 0;
        int[] result = helper(root, distance);
        return result[distance + 1]; // последний элемент массива - количество пар
    }

    private int[] helper(TreeNode node, int distance) {
        if (node == null) return new int[distance + 2];

        if (node.left == null && node.right == null) {
            int[] leafDistances = new int[distance + 2];
            leafDistances[1] = 1;
            return leafDistances;
        }

        int[] leftDistances = helper(node.left, distance);
        int[] rightDistances = helper(node.right, distance);

        int[] currentDistances = new int[distance + 2];
        int count = leftDistances[distance + 1] + rightDistances[distance + 1];

        for (int i = 1; i <= distance; i++) {
            for (int j = 1; j <= distance - i; j++) {
                count += leftDistances[i] * rightDistances[j];
            }
        }

        for (int i = 1; i <= distance; i++) {
            currentDistances[i + 1] = leftDistances[i] + rightDistances[i];
        }

        currentDistances[distance + 1] = count;
        return currentDistances;
    }
}