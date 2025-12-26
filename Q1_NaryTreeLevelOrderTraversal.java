import java.util.*;

class Q1_NaryTreeLevelOrderTraversal {
    
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
            children = new ArrayList<>();
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                level.add(curr.val);

                for (Node child : curr.children) {
                    q.add(child);
                }
            }
            result.add(level);
        }
        return result;
    }

    public static void main(String[] args) {

        /*
                1
              / | \
             3  2  4
            / \
           5   6

        Output:
        [[1], [3, 2, 4], [5, 6]]
        */

        Node root = new Node(1);

        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node4 = new Node(4);

        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node3.children.add(node5);
        node3.children.add(node6);

        root.children.add(node3);
        root.children.add(node2);
        root.children.add(node4);

        List<List<Integer>> result = levelOrder(root);
        System.out.println(result);
    }
}
