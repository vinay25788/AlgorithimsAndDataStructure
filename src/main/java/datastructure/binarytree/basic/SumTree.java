package datastructure.binarytree.basic;

public class SumTree {
    Node root;


    public int toSumTree(Node node)
    {
        if(node == null)
            return 0;
        int oldValue = node.data;
        node.data = toSumTree(node.left)+toSumTree(node.right);
        return node.data+oldValue;

    }

    public static void main(String[] args) {

        SumTree tree = new SumTree();

        /* Constructing tree given in the above figure */
        tree.root = new Node(10);
        tree.root.left = new Node(-2);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(-4);
        tree.root.right.left = new Node(7);
        tree.root.right.right = new Node(5);
        tree.toSumTree(tree.root);
       tree. printInOrder(tree.root);
    }
    public  void printInOrder(Node root)
    {
        if(root == null)
            return;
        printInOrder(root.left);
        System.out.print(root.data+" ");
        printInOrder(root.right);
    }
}
