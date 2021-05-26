package datastructure.binarytree.basic;

class CNode
{
    char data;
    CNode left,right;
    CNode(char data)
    {
        this.data  = data;
        this.left = null;
        this.right = null;
    }
}

public class ConvertTernaryExpression {

    CNode root;
    public static void inOrder(CNode temp)
    {
        if(temp == null)
            return;

        System.out.print(temp.data + " ");
        inOrder(temp.left);
        inOrder(temp.right);


    }
    public CNode convertExpression(char[] exp,int i)
    {
        if(i>exp.length)
            return null;
        CNode temp = new CNode(exp[i]);

        i++;
        if(i<exp.length&& exp[i] =='?')
            temp.left = convertExpression(exp,i+1);
        else
            temp.right = convertExpression(exp,i+1);
        return temp;
    }
    public static void main(String[] args) {
        ConvertTernaryExpression obj = new ConvertTernaryExpression();
        String exp = "a?b?c:d:e";
      obj. root =   obj.convertExpression(exp.toCharArray(),0);
      inOrder(obj.root);
    }
}
