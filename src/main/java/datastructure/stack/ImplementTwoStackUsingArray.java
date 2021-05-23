package datastructure.stack;

public class ImplementTwoStackUsingArray {
    int top1 =-1,top2;
    int size;
    int[] a;
    ImplementTwoStackUsingArray(int size)
    {
        this.size = size;
        top2 = size;
        a = new int[size];
    }

    public void push1(int data)
    {
        if(top1<top2)
        {
            top1++;
            a[top1] = data;
        }
        else
        {
            System.out.println(" stack overflow ");
        }
    }
    public void push2(int data)
    {
        if(top1<top2)
        {
            top2--;
            a[top2] = data;
        }
        else
        {
            System.out.println(" stack overflow ");
        }
    }

    public int pop1()
    {
        if(top1>=0)
        {

            int x= a[top1];
            top1--;
            return x;
        }
        else
        {
            System.out.println(" stack underflow ");
        }


        return -1;
    }

    public int pop2()
    {
        if(top2<size)
        {
            int x= a[top2];
            top2++;
            return x;
        }
        else
        {
            System.out.println(" stack underflow ");
            System.exit(1);
        }
        return -1;
    }

    public static void main(String[] args) {
        ImplementTwoStackUsingArray obj = new ImplementTwoStackUsingArray(5);
        obj.push1(1);
        obj.push1(2);
        obj.push1(3);
        obj.push2(4);
        obj.push2(5);
        System.out.println(" first stack");
        System.out.println(obj.pop1());
        System.out.println(obj.pop1());
        System.out.println(obj.pop1());
        System.out.println(obj.pop1());
        System.out.println(" second stack ");
        System.out.println(obj.pop2());
        System.out.println(obj.pop2());
        System.out.println(obj.pop2());

    }
}
