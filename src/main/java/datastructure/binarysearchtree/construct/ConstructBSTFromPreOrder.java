package datastructure.binarysearchtree.construct;


import java.util.Stack;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class ConstructBSTFromPreOrder {

    static Node root;

    public static void insert(int data) {
        root = insertRec(root, data);
    }

    public static Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);
        return root;
    }

    public static void inOrder(Node root) {
        if (root == null)
            return;
        else {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        insert(5);
        insert(15);
        insert(3);
        insert(4);
        insert(13);
        insert(10);
        inOrder(root);

        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        int size = pre.length;
        root = null;
        Node root2 = constructTree(pre, size);
        System.out.println();
        System.out.println(" construct using preOrder ");

        inOrder(root2);

    }

    public static Node constructTree(int[] pre,int size)
    {
        Node root = new Node(pre[0]);
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        for(int i=1;i<size;i++)
        {
            Node temp = null;
            while(!stack.isEmpty() && pre[i]>stack.peek().data)
            {
                temp=    stack.pop();
            }
            if(temp != null)
            {
                temp.right = new Node(pre[i]);
                stack.push(temp.right);
            }
            else
            {
                temp = stack.peek();
                temp.left = new Node(pre[i]);
                stack.push(temp.left);
            }
        }
        return root;
    }
}
