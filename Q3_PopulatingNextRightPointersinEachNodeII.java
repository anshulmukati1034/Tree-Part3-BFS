public class Q3_PopulatingNextRightPointersinEachNodeII {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }   
    public static Node connect(Node root) {
        Node curr = root;

        while (curr != null) {
            Node dummy = new Node(0);
            Node tail = dummy;

            while (curr != null) {
                if (curr.left != null) {
                    tail.next = curr.left;
                    tail = tail.next;
                }
                if (curr.right != null) {
                    tail.next = curr.right;
                    tail = tail.next;
                }
                curr = curr.next;
            }
            curr = dummy.next;
        }
        return root;
    }

    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             / \   \
            4   5   7

        After calling connect, the tree should look like:
                1 -> NULL
               / \
              2 -> 3 -> NULL
             / \    \
            4-> 5 -> 7 -> NULL
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);

        connect(root);

        // Print next pointers for each level
        Node levelStart = root;
        while (levelStart != null) {
            Node curr = levelStart;
            levelStart = null;
            while (curr != null) {
                System.out.print(curr.val + " -> ");
                if (levelStart == null) {
                    if (curr.left != null) levelStart = curr.left;
                    else if (curr.right != null) levelStart = curr.right;
                }
                curr = curr.next;
            }
            System.out.println("NULL");
        }
    }   
}
