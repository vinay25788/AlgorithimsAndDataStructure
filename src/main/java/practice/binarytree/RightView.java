package practice.binarytree;

public class RightView {
    static LeftVeiw.Node root;
    static int maxLevel=0;

    static class Node {
        int data;
        LeftVeiw.Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private static void rightView(LeftVeiw.Node root) {
        System.out.print(root.data+" ");
        util(root, 0);
    }
    private static void util(LeftVeiw.Node root, int level)
    {
        if(root == null)
            return;
        if(level>maxLevel)
        {
            System.out.print(root.data+" ");
            maxLevel = level;
        }
        util(root.right,level+1);
        util(root.left,level+1);
    }

    public static void main(String[] args) {

        root = new LeftVeiw.Node(1);
        root.left = new LeftVeiw.Node(2);
        root.left.right = new LeftVeiw.Node(3);
        root.left.left = new LeftVeiw.Node(4);
        root.right = new LeftVeiw.Node(5);
        root.right.right = new LeftVeiw.Node(6);
        root.right.left = new LeftVeiw.Node(7);
        root.right.left.left = new LeftVeiw.Node(8);
        root.right.left.right = new LeftVeiw.Node(9);
        rightView(root);
    }
}
