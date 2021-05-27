package datastructure.binarytree.basic;

import java.util.LinkedList;
import java.util.Queue;

public class CheckLeaveNodeAtSameLevel {

    public static boolean checkLevelLeafNode(Node root) {
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        int result = Integer.MAX_VALUE;
        int level = 0;
        while (que.size() != 0) {
            int size = que.size();
            level++;
            while (size > 0) {
                Node temp = que.remove();
                if (temp.left != null) {
                    que.add(temp.left);
                    if (temp.left.left == null && temp.left.right == null) {
                        if (result == Integer.MAX_VALUE)
                            result = level;

                        else if (result != level)
                            return false;
                    }
                }
                if (temp.right != null) {
                    que.add(temp.right);
                    if (temp.right.left == null && temp.right.left == null) {
                        if (result == Integer.MAX_VALUE)
                            result = level;

                        else if (result != level)
                            return false;
                    }
                    size--;

                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.right.right = new Node(7);

        boolean result = checkLevelLeafNode(root);
        if (result == true)
            System.out.println("All leaf nodes are at same level");
        else
            System.out.println("Leaf nodes not at same level");
    }
}
