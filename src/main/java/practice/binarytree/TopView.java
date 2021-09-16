package practice.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopView {

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

    private static void topView() {
        Map<Integer, Integer> map = new HashMap<>();
        util(root, map, 0);
   
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            System.out.print(entry.getValue() + " ");
        }
    }

    private static void util(Node root, Map<Integer, Integer> map, int dist) {
        if (root == null) {
            return;
        }
        if (map.get(dist) == null)
            map.put(dist, root.data);
        util(root.left, map, dist - 1);
        util(root.right, map, dist + 1);
    }

    public static void main(String[] args) {

        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);


        topView();


    }
}
