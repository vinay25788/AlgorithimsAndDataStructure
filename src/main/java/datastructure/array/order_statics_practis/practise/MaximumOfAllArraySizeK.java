package datastructure.array.order_statics_practis.practise;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumOfAllArraySizeK {

    public static void main(String[] args) {
        int[] a ={5,10,3,9,15,24,15};
        int k =3 ;
        findMax(a,k);
    }
    public static void findMax(int[] a,int k)
    {
        int n = a.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for(int i=0;i<k;i++)
        {
            while(!deque.isEmpty() && a[i]>=a[deque.peekLast()])
                deque.removeLast();
            deque.addLast(i);
        }
        for(int i=k;i<n;i++)
        {
            System.out.print(" "+a[deque.peek()]+" ");
            while(!deque.isEmpty() && deque.peek()<i-k)
                deque.removeFirst();
            while(!deque.isEmpty() && a[i]>=a[deque.peekLast()])
                deque.removeLast();
            deque.addLast(i);
        }
        System.out.print(a[deque.peek()]);
    }
}
