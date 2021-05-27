package datastructure.binarytree.basic;

public class PrintAllRootToLeaf {
    Node root;
    public static void main(String[] args) {
        PrintAllRootToLeaf tree = new PrintAllRootToLeaf();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        /* Print all root-to-leaf paths of the input tree */
        tree.printPaths(tree.root);
    }

    public void printPaths(Node root)
    {
        int[] path = new int[1000];
        printPathRecur(root,path,0);
    }
    public void printPathRecur(Node root, int[] path,int length)
    {
        if(root == null)
            return;
        path[length++] = root.data;
        if(root.left == null && root.right == null)
            printArray(path,length);
        else
        {
            printPathRecur(root.left, path, length);
            printPathRecur(root.right,path,length);
        }
    }

    public void printArray(int[] path,int length)
    {
        for(int i=0;i<length;i++)
        {
            System.out.print(path[i]+" ");
        }
        System.out.println();
    }

}
