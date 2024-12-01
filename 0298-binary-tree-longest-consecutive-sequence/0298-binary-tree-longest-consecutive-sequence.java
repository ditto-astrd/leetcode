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
    public int longestConsecutive(TreeNode root) {
        return dfs(root, 1, 1, Integer.MAX_VALUE);
    }

    private int dfs(TreeNode cur, int curLen, int maxLen, int before) {
        if (cur == null) {
            return maxLen;
        }

        curLen = cur.val - before == 1 ? curLen + 1 : 1;
        maxLen = Math.max(curLen, maxLen);

        return Math.max(maxLen, Math.max(dfs(cur.left, curLen, maxLen, cur.val), dfs(cur.right, curLen, maxLen, cur.val)));
    }
}