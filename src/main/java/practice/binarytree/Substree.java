package practice.binarytree;

import java.util.ArrayList;
import java.util.List;

public class Substree {

    static class Node
    {
        char data;
        Node left,right;
        Node (char data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static Node root,root2;

    static List<Character> list1 = new ArrayList<>();
    static List<Character> list2 = new ArrayList<>();

    private static void subtree(Node root1,Node root2)
    {
        storeInOrder(root1,list1);
        storeInOrder(root2,list2);

        System.out.println(compareInorder(list1,list2));
        list1.clear();
        list2.clear();
        list1.clear();
        list2.clear();
        System.out.println("list 1"+list1);
        System.out.println("list 2"+list2);
        storePreOrder(root1,list1);
        storePreOrder(root2,list2);
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(compareInorder(list1,list2));
    }

    private static boolean compareInorder(List<Character> list1,List<Character> list2)
    {
        int count=0;
        System.out.println(list1.size()+" "+list2.size());
        for(int i=0;i<=list1.size()-list2.size();i++)
        {
            if(list1.get(i) == list2.get(0)) {
                int j = 0;
                for (; j < list2.size(); j++) {
                    if (list1.get(i + j) != list2.get(j)) {
                        break;

                    }


                }
                if(j == list2.size())
                    return true;
            }

        }
        System.out.println(count);
      return count == list2.size();
    }

    private static void storeInOrder(Node root,List<Character> list)
    {
        if(root!= null)
        {
            storeInOrder(root.left,list);
            list.add(root.data);
            storeInOrder(root.right,list);


        }
    }
    private static void storePreOrder(Node root,List<Character> list)
    {
        if(root!= null)
        {

            list.add(root.data);
            storeInOrder(root.left,list);
            storeInOrder(root.right,list);


        }
    }
    public static void main(String[] args) {

        Node root = new Node('a');
        root.left = new Node('b');
        root.right = new Node('d');
        root.left.left = new Node('c');
        root.right.right = new Node('e');

        Node S = new Node('a');
        S.left = new Node('b');
        S.right = new Node('d');
        S.left.left = new Node('c');



        subtree(root,S);


    }
}
