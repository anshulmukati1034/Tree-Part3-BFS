import java.util.*;

public class Q4_CheckCompletenessofaBinaryTree {
    static class TreeNode {
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
    public static boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean foundNull = false;

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr == null) {
                foundNull = true;
            } else {
                if (foundNull) return false;

                q.add(curr.left);
                q.add(curr.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             / \   \
            4   5   7

        This tree is not complete because node 3 is missing a left child.
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println(isCompleteTree(root)); // Output: false
    }
}
