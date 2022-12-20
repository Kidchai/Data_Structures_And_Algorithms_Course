package kidchai.algortithms.tasks.leetcode.problem145;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> values = new ArrayList<>();
        values.addAll(postorderTraversal(root.left));
        values.addAll(postorderTraversal(root.right));
        values.add(root.val);
        return values;
    }
}