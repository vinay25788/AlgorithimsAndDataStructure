package datastructure.array.order_statics;

import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int a[]= {11, 13, 21, 3};
        find(a);
    }
    public static void find(int[] a)
    {
       int n= a.length;
        Stack<Integer>  stack = new Stack<>();
        stack.push(a[0]);
        int element = -1,next=-1;
        for(int i=1;i<n;i++)
        {
             next = a[i];

             if(stack.isEmpty() == false)
             {
                 element = stack.pop();
                 while( next>element)
                 {
                     System.out.println("element "+element+"   Greater "+next);
                     if(stack.isEmpty())
                         break;
                     element = stack.pop();
                 }
                 if(element>next)
                     stack.push(element);

             }
             stack.push(next);
        }

        while(!stack.isEmpty())
        {

            System.out.println("element  "+stack.pop()+"   Greater  -1");
        }

    }
}
