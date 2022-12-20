package kidchai.algortithms.tasks.leetcode.problem94;

import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> values = new ArrayList<>(inorderTraversal(root.left));
        values.add(root.val);
        values.addAll(inorderTraversal(root.right));
        return values;
    }
}
