package kidchai.algortithms.tasks.leetcode.problem100;

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean isSame;
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }
        isSame = isSameTree(p.left, q.left);
        if (!isSame) {
            return false;
        }
        isSame = isSameTree(p.right, q.right);
        return isSame;
    }
}
