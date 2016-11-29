package ctci;

/**
 * Created by dgore7 on 11/27/2016.
 */
public class FirstCommonAncestor {
    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data,Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static class Result {
        Node node;
        boolean isAncestor;
        public Result(Node n, boolean isAncestor) {
            this.node = n;
            this.isAncestor = isAncestor;
        }
    }


    Result firstCommonAncestor(Node current, Node p, Node q) {
        if (current == null) return new Result(null, false);
        if (current.equals(p) && current.equals(q))
            return new Result(current,true);
        Result left = firstCommonAncestor(current.left, p, q);
        if (left.isAncestor) return left;

        Result right = firstCommonAncestor(current.right, p, q);
        if (right.isAncestor) return right;

        if (left.node != null && right.node != null)
            return new Result(current, true);

        if (current.equals(p) || current.equals(q)) {
            return new Result(current, left.node != null || right.node != null);
        }

        if (right.node == null) return left;
        return right;
    }

    public static Node getNode(Node current, int key) {
        if (current == null) return null;
        if (current.data == key) return current;
        Node left = getNode(current.left, key);
        Node right = getNode(current.right, key);
        return left == null ? right : left;
    }

    public static void main(String[] args) {
        FirstCommonAncestor fca = new FirstCommonAncestor();
        Node root = new Node(12,
                new Node(23,
                        new Node(14, null, null),
                        new Node(15, null, null)
                        ),
                new Node (134,
                        new Node(142, null, null),
                        new Node(90, null, null)
                )
        );
        Result res = fca.firstCommonAncestor(root,getNode(root,14), getNode(root, 23));

        System.out.println(res.isAncestor ? res.node.data : null);
    }
}
