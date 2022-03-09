package datastructure.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Pair
{
    int ele;
    int ind;
    Pair(int ele,int ind)
    {
        this.ele = ele;
        this.ind = ind;
    }
}
public class StockSpan {
    public static void main(String[] args) {
        int[] a ={100,80,60,70,60,75,85};
        printStockValue(a);
    }
    public static void printStockValue(int[] a)
    {
        Stack<Pair> st = new Stack<>();
        List<Integer> res = new ArrayList<>();


        for(int i=0;i<a.length;i++)
        {
            while(!st.isEmpty() && st.peek().ele<=a[i])
                st.pop();


           if(st.isEmpty())
           {
               res.add(-1);
           }
           else
              res.add(st.peek().ind);
           st.push(new Pair(a[i],i));

        }


        System.out.println(Arrays.toString(res.toArray()));

        for(int i=0;i<a.length;i++)
            res.set(i,i-res.get(i));

        System.out.println(Arrays.toString(res.toArray()));
    }
}
