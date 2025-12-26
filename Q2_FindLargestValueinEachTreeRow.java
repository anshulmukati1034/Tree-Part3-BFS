import java.util.*;

class Q2_FindLargestValueinEachTreeRow {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                max = Math.max(max, curr.val);

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            result.add(max);
        }
        return result;
    }

    public static void main(String[] args) {

        /*
                1
               / \
              3   2
             / \   \
            5   3   9

        Output:
        [1, 3, 9]
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        List<Integer> largestValues = largestValues(root);
        System.out.println(largestValues); // Output: [1, 3, 9]
    }   
}
