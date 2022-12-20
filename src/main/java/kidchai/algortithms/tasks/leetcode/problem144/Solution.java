package kidchai.algortithms.tasks.leetcode.problem144;

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
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> values = new ArrayList<>();
        values.add(root.val);
        values.addAll(preorderTraversal(root.left));
        values.addAll(preorderTraversal(root.right));
        return values;
    }
}