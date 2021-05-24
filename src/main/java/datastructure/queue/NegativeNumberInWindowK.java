package datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;

public class  NegativeNumberInWindowK {
    public static void main(String[] args) {
        NegativeNumberInWindowK obj = new NegativeNumberInWindowK();
        int a[] = {1,-1,3,4,-5,06,-9};
        int k = 2;
        findNegative(a,k);
    }
    public static void findNegative(int[] a,int k)
    {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<k;i++)
            if(a[i]<0)
                queue.add(i);

        for(int i=k;i<a.length;i++)
        {
            if(!queue.isEmpty())
                System.out.print(" "+a[queue.peek()]);
            else
                System.out.print(" 0 ");

            if(a[i]<0)
                queue.add(i);
            while ( (!queue.isEmpty() ) && queue.peek()<i-k+1)
                queue.remove();
        }

        if(!queue.isEmpty())
            System.out.print(" "+a[queue.peek()]);
        else
            System.out.print(" 0 ");
    }
}
