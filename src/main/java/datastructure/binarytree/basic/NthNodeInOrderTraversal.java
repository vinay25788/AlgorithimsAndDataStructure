package datastructure.binarytree.basic;

public class NthNodeInOrderTraversal {
    static int count =0;
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        findNthNodeInorder(root, 5);

    }
    public static void findNthNodeInorder(Node root,int n)
    {
        if(root == null)
            return;

        if(count<=n) {
            findNthNodeInorder(root.left, n);
            count++;
            if (count == n) {
                System.out.println(root.data + " ");
                return;
            }

            findNthNodeInorder(root.right, n);
        }


    }
}
