package kidchai.algortithms.tasks.leetcode.problem111;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 0;
        int right = 0;
        left += minDepth(root.left) + 1;
        right += minDepth(root.right) + 1;
        return left == 1 || right == 1 ? Math.max(left, right) : Math.min(left, right);
    }
}
