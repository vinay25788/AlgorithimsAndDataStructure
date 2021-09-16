package practice.binarytree;

public class SumTree {

    Node root;

   static class Node
    {
        int data;
        Node left,right;
        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private int toSumTree(Node node)
    {
        if(node == null)
            return 0;
        int oldValue = node.data;
        node.data = toSumTree(node.left)+toSumTree(node.right);
        return node.data+oldValue;
    }

    private void printInorder(Node root)
    {
        if(root != null)
        {
            printInorder(root.left);
            System.out.print(root.data+" ");
            printInorder(root.right);
        }


    }

    public static void main(String[] args) {
        SumTree tree = new SumTree();
        tree.root = new Node(10);
        tree.root.left = new Node(-2);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(-4);
        tree.root.right.left = new Node(7);
        tree.root.right.right = new Node(5);

        tree.toSumTree(tree.root);

        // Print inorder traversal of the converted tree to test result
        // of toSumTree()
        System.out.println("Inorder Traversal of the resultant tree is:");
        tree.printInorder(tree.root);
    }
}
