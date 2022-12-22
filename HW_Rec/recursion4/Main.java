package four_tree;
//Реализуйте бинарное дерево поиска
public class Main {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

        // заполняем дерево
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.right.right = new Node(5);
        tree.root.right.right.right = new Node(7);

        System.out.print("Бинарное дерево слева направо: ");
        tree.leftRight(tree.root);
        System.out.println();
        System.out.println("Искомый элемент: " + tree.NodeByValue(3).key + "находится в узле " + tree.NodeByValue(3));
    }

}
