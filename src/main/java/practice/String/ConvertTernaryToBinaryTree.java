package practice.String;

public class ConvertTernaryToBinaryTree {


  static  class Node
    {
        char data;
        Node left,right;

        Node(char data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static void main(String[] args) {
        String st = "a?b?c:d:e";
       Node root =  convert(st,0);
       inOrder(root);
    }
    private static Node convert(String st,int i)
    {
        if( i>= st.length())
            return null;

        Node root = new Node(st.charAt(i));
        ++i;

        if(i<st.length() && st.charAt(i) == '?')
            root.left = convert(st,i+1);
        else if(i< st.length() )
            root.right = convert(st,i+1);

        return root;
    }

    private static void inOrder(Node root)
    {
        if(root != null)
        {
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);

        }
    }
}
