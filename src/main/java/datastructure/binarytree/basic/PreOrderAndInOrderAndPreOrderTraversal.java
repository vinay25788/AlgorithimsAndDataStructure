package datastructure.binarytree.basic;


public class PreOrderAndInOrderAndPreOrderTraversal {

    public void inOrder(Node root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void preOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(Node root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        System.out.println();
        System.out.println("inorder ");
        System.out.println();
        PreOrderAndInOrderAndPreOrderTraversal obj = new PreOrderAndInOrderAndPreOrderTraversal();
        obj.inOrder(root);
        System.out.println();
        System.out.println(" pre order ");
        System.out.println();
        obj.preOrder(root);
        System.out.println();
        System.out.println(" post order ");
        System.out.println();
        obj.postOrder(root);
    }
}
