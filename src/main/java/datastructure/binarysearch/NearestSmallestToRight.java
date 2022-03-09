package datastructure.binarysearch;

import java.util.*;

public class NearestSmallestToRight {
    public static void main(String[] args) {
        int[] a ={4,5,2,10,8};
        System.out.println(Arrays.toString(findSmallest(a)));
    }
    public static int[] findSmallest(int[] a)
    {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[a.length];
        List<Integer> list = new ArrayList<>();
        for(int i=a.length-1;i>=0;i--)
        {
            while(!st.isEmpty() && st.peek()>=a[i])
                st.pop();
            if(st.isEmpty())
                list.add(-1);
            else
                list.add(st.peek());
            st.push(a[i]);

        }
        Collections.reverse(list);
        int ind =0;
        list.forEach(i->{
            System.out.println(i);
        });
        for(int i=0;i<list.size();i++)
            res[ind++] = list.get(i);
        return res;
    }
}
