import java.util.*;

public class Q5_AllNodesDistanceKinBinaryTree {
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

    // Step 1: Map child -> parent
    private static void buildParentMap(TreeNode root, Map<TreeNode, TreeNode> parent) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr.left != null) {
                parent.put(curr.left, curr);
                q.add(curr.left);
            }
            if (curr.right != null) {
                parent.put(curr.right, curr);
                q.add(curr.right);
            }
        }
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        buildParentMap(root, parent);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.add(target);
        visited.add(target);

        int distance = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            if (distance == k) break;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                // left
                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    q.add(curr.left);
                }

                // right
                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    q.add(curr.right);
                }

                // parent
                if (parent.containsKey(curr) && !visited.contains(parent.get(curr))) {
                    visited.add(parent.get(curr));
                    q.add(parent.get(curr));
                }
            }
            distance++;
        }

        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            result.add(q.poll().val);
        }

        return result;
    }

    public static void main(String[] args) {
        /*
                3
               / \
              5   1
             / \ / \
            6  2 0  8
              / \
             7   4

        Target = 5, K = 2
        Nodes at distance 2 from target (5) are [7,4,1]
        */

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode target = root.left; // Node with value 5
        int k = 2;

        List<Integer> result = distanceK(root, target, k);
        System.out.println(result); // Output: [7, 4, 1]
    }
}
