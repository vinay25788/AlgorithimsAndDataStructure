package datastructure.stack;

import java.util.Stack;

public class SpecialStack extends Stack<Integer> {
    Stack<Integer> min = new Stack<>();

    public void insert(int data)
    {
        super.push(data);
        if(min.isEmpty())
            min.push(data);
        else
        {
            if(data<min.peek())
                min.push(data);
            else
                min.push(min.peek());
        }
    }

    public int extract()
    {
        if(min.isEmpty())
        {
            System.out.println(" no element found ");

        }
        else
        {
            int x= super.pop();
            min.pop();
            return x;
        }
        return -1;
    }

    public int getMin()
    {
        return min.peek();
    }

    public static void main(String[] args) {

        SpecialStack obj = new SpecialStack();
        obj.insert(10);
        obj.insert(8);
        obj.insert(5);
        obj.insert(3);
        obj.insert(14);
        obj.insert(2);

        System.out.println(obj.extract());
        System.out.println(obj.getMin());
        System.out.println(obj.extract());
        System.out.println(obj.extract());
        System.out.println(obj.getMin());

    }
}
