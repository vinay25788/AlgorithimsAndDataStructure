package practice.binarytree;

public class ConvertTernaryToBinaryTree {

    static class Node {
        char data;
        Node left, right;

        Node(char data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static Node root;

    private static Node convert(String st, int ind) {
        if (ind >= st.length())
            return null;
        char ch = st.charAt(ind);
        ++ind;

        Node cur = new Node(ch);

        if (ind < st.length() && st.charAt(ind + 1) == '?')
            cur.left = convert(st, ind + 1);
        else if (ind < st.length())
            cur.right = convert(st, ind + 1);

        return cur;
    }

    private static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        String st = "a?b?c:d:e";
        ConvertTernaryToBinaryTree.root = convert(st, 0);

        inOrder(ConvertTernaryToBinaryTree.root);
    }
}
