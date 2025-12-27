import java.util.*;

public class Q6_BinaryTreebottomSideView {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static List<Integer> bottomView(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            Node node = curr.node;
            int hd = curr.hd;

            // overwrite allowed (bottom view logic)
            map.put(hd, node.val);

            if (node.left != null)
                q.add(new Pair(node.left, hd - 1));

            if (node.right != null)
                q.add(new Pair(node.right, hd + 1));
        }

        for (int val : map.values()) {
            result.add(val);
        }

        return result;
    }

    public static void main(String[] args) {
        /*
                20
               /  \
              8    22
             / \     \
            5   3     25
               / \
              10 14

        Bottom view: 5, 10, 3, 14, 25
        */

        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        List<Integer> bottomViewResult = bottomView(root);
        System.out.println(bottomViewResult); // Output: [5, 10, 3, 14, 25]
    }
}
