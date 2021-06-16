package datastructure.binarysearchtree.construct;

public class MergeTwoBinaryTree {


    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class SNode
    {
        SNode head;
        Node t;
        SNode next;
        void push (Node k)
        {
            SNode temp = new SNode();
            temp.t = k;
            temp.next = this.head;
            this.head = temp;

        }
        Node pop()
        {
            SNode st;
            st = this.head;
            head = st.next;
            return st.t;
        }
        boolean isEmpty()
        {
            if(this.head == null)
                return true;
            return false;
        }
    }

    public static void main(String[] args) {
        Node root1 = null, root2 = null;

        /* Let us create the following tree as first tree
                3
            / \
            1 5
        */
        root1 = new Node(3) ;
        root1.left = new Node(1);
        root1.right = new Node(5);

        /* Let us create the following tree as second tree
                4
            / \
            2 6
        */
        root2 = new Node(4) ;
        root2.left = new Node(2);
        root2.right = new Node(6);

        // Print sorted nodes of both trees
        merge(root1, root2);
    }

    public static void inorder(Node root)
    {
        if(root != null)
        {
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }

    public static void merge(Node root1,Node root2)
    {
        SNode s1 = new SNode();
        Node cur1 = root1;
        SNode s2 = new SNode();
        Node cur2 = root2;
        if(root1 == null)
        {
            inorder(root2);
            return;
        }
        if(root2 == null)
        {
            inorder(root1);
            return;
        }
        while(cur1 != null || !s2.isEmpty()|| cur2 != null || !s2.isEmpty())
        {
            if(cur1 != null || cur2!= null)
            {
                if(cur1 != null)
                {
                    s1.push(cur1);
                    cur1 = cur1.left;
                }
                if(cur2 != null)
                {
                    s2.push(cur2);
                    cur2 = cur2.left;
                }
            }
            else
            {
                if(s1.isEmpty())
                {
                    while(!s2.isEmpty())
                    {
                        cur2 = s2.pop();
                        cur2.left = null;
                        inorder(cur2);
                    }
                    return;
                }
                if(s2.isEmpty())
                {
                    while(!s1.isEmpty())
                    {
                        cur1 = s1.pop();
                        cur1.left = null;
                        inorder(cur1);
                    }
                    return;
                }

                cur1 = s1.pop();
                cur2 = s2.pop();

                if(cur1.data < cur2.data)
                {
                    System.out.print(cur1.data+" ");
                    cur1 = cur1.right;
                    s2.push(cur2);
                    cur2 = null;
                }
                else
                {
                    System.out.print(cur2.data+" ");
                    cur2 = cur2.right;
                    s1.push(cur1);
                    cur1 = null;
                }

            }
        }
        System.out.print(s1.t.data+" ");
        System.out.print(s2.t.data+" ");
    }


}
