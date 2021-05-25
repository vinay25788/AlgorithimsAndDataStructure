package datastructure.binarytree.basic;

import java.util.*;

class MyClass<T>
{
    void add(T t)
    {
        System.out.println(t);
    }
}

public class InOrderTraversalWithoutRecursion {

    public static void inOrderTraversalWithoutRecursion(Node root) {

        if (root == null)
            return;
        Stack<Node> st = new Stack<>();
        Node cur = root;

        while (cur != null || st.size() > 0) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }

            cur = st.pop();
            System.out.print(" " + cur.data);
            cur = cur.right;
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        inOrderTraversalWithoutRecursion(root);

        MyClass<Number> myadd = new MyClass<>();
        myadd.add(1);
        myadd.add(1.0);
        myadd.add(3);

        /*List list = new ArrayList<>();
        list.add(1);

        for(Object ob:revers(list))
        {
            System.out.println(ob+" ");
        }
*/

    }
    public static Iterator revers(List list)
    {
        Collections.reverse(list);
        return list.iterator();
    }
}
