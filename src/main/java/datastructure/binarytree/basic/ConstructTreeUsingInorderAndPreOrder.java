package datastructure.binarytree.basic;

public class ConstructTreeUsingInorderAndPreOrder {


   static  class Node
    {
        char data;
        Node left,right;
        Node(char data)
        {
            this.data = data;
            this.left  = null;
            this.right = null;
        }
    }
    Node root;
    static int preIndex = 0;

    public static void main(String[] args) {
        char in[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char pre[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};

        Node root = constructTree(in, pre, 0, in.length - 1);
        printInOder(root);
    }

    public static Node constructTree(char[] in, char[] pre, int inStart, int inEnd) {
        if (inStart > inEnd)
            return null;
        Node tNode = new Node(pre[preIndex++]);
        int inIndex = search(in, tNode.data);

        if (inStart == inEnd)
            return tNode;
        tNode.left = constructTree(in, pre, inStart, inIndex - 1);
        tNode.right = constructTree(in, pre, inIndex + 1, inEnd);
        return tNode;
    }

    public static int search(char[] in, char value) {
        int n = in.length;
        for (int i = 0; i < n; i++) {
            if (in[i] == value)
                return i;
        }
        return -1;
    }

    public static void printInOder(Node root) {
        if (root == null)
            return;
        printInOder(root.left);
        System.out.print(root.data + " ");
        printInOder(root.right);
    }
}
