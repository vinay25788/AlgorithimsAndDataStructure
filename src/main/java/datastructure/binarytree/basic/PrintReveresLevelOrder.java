package datastructure.binarytree.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PrintReveresLevelOrder {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        reverseLevelOrder(root);
    }
    public static void reverseLevelOrder(Node root)
    {
        if(root == null)
            return;
        Queue<Node> que = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        que.add(cur);
        while(!que.isEmpty())
        {
            Node temp = que.remove();
            stack.push(temp);
            if(temp.right != null)
                que.add(temp.right);
            if(temp.left != null)
                que.add(temp.left);

        }
        while(!stack.isEmpty())
        {
            Node node = stack.pop();
            System.out.print(node.data+" ");
        }
    }
}
