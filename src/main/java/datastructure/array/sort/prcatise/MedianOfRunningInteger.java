package datastructure.array.sort.prcatise;


import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfRunningInteger {
    public static void main(String[] args) {
        int[] a={5,15,10,20,3};
        find(a);
    }
    public static void find(int[] a)
    {
        double median = a[0];
        PriorityQueue<Integer> smaller = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> greater = new PriorityQueue<>();
        smaller.add(a[0]);
        System.out.print(" "+median);
        int n = a.length;
        for(int i=1;i<n;i++)
        {
            int x = a[i];
            if(smaller.size()>greater.size())
            {
                if(x<median)
                {
                    greater.add(smaller.remove());
                    smaller.add(x);
                }
                else
                    greater.add(x);
                median = (double) (smaller.peek()+greater.peek())/2;
            }
            else if ( smaller.size() == greater.size())
            {
                if(x<median)
                {
                    smaller.add(x);
                    median = (double) smaller.peek();
                }

                else
                {
                    greater.add(x);
                    median = (double) greater.peek();
                }
            }
            else
            {
                if(x>median)
                {
                    smaller.add(greater.remove());
                    greater.add(x);
                }
                else
                    smaller.add(x);

                median = (double) (smaller.peek()+greater.peek())/2;
            }
            System.out.print(" "+median);
        }

    }
}
