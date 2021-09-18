package practice.binarysearchtree;

public class KthSmallestInBST {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static Node root;
    static int count;

    private static void  kthSmallest(Node root, int k) {
        if (root == null|| count>=k)
            return ;
        kthSmallest(root.left, k);

        count++;

        if (count == k) {

            System.out.println(root.data);
        }
        kthSmallest(root.right, k);
    }

    private static void  kthLargest(Node root, int k) {
        if (root == null)
            return ;
        kthLargest(root.right, k);

        count++;

        if (count == k) {

            System.out.println(root.data);
        }
        kthLargest(root.left, k);
    }


    public static void main(String[] args) {
        root = new Node(5);
        root.left = new Node(3);
        root.left.right = new Node(4);
        root.left.left = new Node(2);
        root.right = new Node(10);
        kthSmallest(root, 3);
        count =0;
        kthLargest(root,2);
    }
}
