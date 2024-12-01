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
    private int ans = 0;

    public int countUnivalSubtrees(TreeNode root) {
        dfs(root);
        return ans;
    }

    private boolean dfs(TreeNode cur) {
        if (cur == null) 
            return true;

        boolean left = dfs(cur.left);
        boolean right = dfs(cur.right);

        if (left && right) {
            if (cur.left != null && cur.left.val != cur.val) 
                return false;
            if (cur.right != null && cur.right.val != cur.val)
                return false;
            ans++;
            return true;
        }

        return false;
    }
}

/**
- subtree가 같으면 됨
- dfs로 subtree의 값이 서로 같은지 판단
- 1,2,3의 트리노드의 정답은 2임 (말단 노드들은 무조건 uniValue로 판단)
 */