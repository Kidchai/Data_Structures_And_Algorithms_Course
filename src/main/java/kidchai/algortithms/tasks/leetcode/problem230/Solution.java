package kidchai.algortithms.tasks.leetcode.problem230;

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
    public static void main(String[] args) {
        //TreeNode root = new TreeNode(4, new TreeNode(2, null, new TreeNode(3)), new TreeNode(5));
        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6));
        System.out.println(kthSmallest(root, 3));
    }

    public static int kthSmallest(TreeNode root, int k) {
        return inorderTraverse(root, k, 0);
    }

    private static int inorderTraverse(TreeNode root, int k, int count) {

        int value = 0;
        if (root == null) {
            return 0;
        }
            value = inorderTraverse(root.left, k, ++count);
            if (value == k || count == k) {
                return value;
            }
            value = inorderTraverse(root.right, k, ++count);
            if (value == k || count == k) {
                return value;
            }
        return root.val;
    }
}
