package practice.datastructure.array.order_static;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElementInStream {
    public static void main(String[] args) {
        int[] a = {  2, 3, 4, 5, 6 ,1};
        int k =4;
        findKth(a,k);
    }
    public static void findKth(int[] a,int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = a.length;
        for(int i=0;i<n;i++)
        {

            if(pq.size()<k)
                pq.add(a[i]);
            else
            {
                if(a[i]<pq.peek())
                {
                    pq.remove();
                    pq.add(a[i]);
                }

            }
            if(pq.size()<k)
                System.out.print("-1 ");
            else
                System.out.print(pq.remove()+" ");
        }
    }
}
