package four_tree;

public class BinaryTree {
    Node root;
    public BinaryTree() {
        root= null;
    }
    // обходим слва направо
    public void leftRight(Node node) {
        if (node != null) {
            leftRight(node.left);
            System.out.print(" " + node.key);
            leftRight(node.right);
        }}
    // поиск по значению
    public Node NodeByValue(int value) {
        Node desireNode = root;
        while (desireNode.key != value) {
            if (value < desireNode.key) {
                desireNode = desireNode.left;
            } else {
                desireNode = desireNode.right;
            }
            if (desireNode == null) {
                return null;
            }
        }
        return desireNode;
    }


    }