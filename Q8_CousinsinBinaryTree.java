import java.util.*;

public class Q8_CousinsinBinaryTree {
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

    public static boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> parentQ = new LinkedList<>();

        q.add(root);
        parentQ.add(null);

        while (!q.isEmpty()) {
            int size = q.size();
            TreeNode parentX = null, parentY = null;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                TreeNode parent = parentQ.poll();

                if (curr.val == x) parentX = parent;
                if (curr.val == y) parentY = parent;

                if (curr.left != null) {
                    q.add(curr.left);
                    parentQ.add(curr);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                    parentQ.add(curr);
                }
            }

            // same level check
            if (parentX != null && parentY != null)
                return parentX != parentY;

            // one found, one not → different level
            if (parentX != null || parentY != null)
                return false;
        }

        return false;
    }

    public static void main(String[] args) {
        /*
                1
               / \
              2   3
               \   \
                4   5

        Nodes 4 and 5 are cousins.
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(isCousins(root, 4, 5)); // Output: true
    }
}

