package practice.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZag {

    static Node root;
    int x;
    public void test()
    {
        root = new Node(4);
    }
    static class Node
    {
        int data;
        Node left,right;
        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }



    private static void zigzag()
    {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        List<List<Integer>> lists = new ArrayList<>();

        s1.push(root);
        boolean flag = true;
        while(!s1.isEmpty() || !s2.isEmpty() )
        {

            List<Integer> list = new ArrayList<>();
            while(!s1.isEmpty())
            {
                Node temp = s1.pop();
                list.add( temp.data);
                if(flag)
                {
                    if(temp.left != null)
                        s2.push(temp.left);
                    if(temp.right != null)
                        s2.push(temp.right);
                }
                else
                {
                    if(temp.right != null)
                        s2.push(temp.right);
                    if(temp.left != null)
                        s2.push(temp.left);
                }
            }
            lists.add(list);
            flag =!flag;
            Stack<Node> t = s1;
            s1 = s2;
            s2 = t;
        }
        System.out.println(lists);
    }

    public static void main(String[] args) {
        root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        zigzag();

    }
}
