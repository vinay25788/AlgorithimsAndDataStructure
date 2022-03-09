package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergePiles {

    static public int mergeStones(int[] a, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<a.length;i++)
            pq.add(a[i]);
        List<Integer> list = new ArrayList<>();
        while(pq.size()>=k)
        {
            int count =0;
            int sum =0;
            while(count<k)
            {
                sum += pq.poll();

                count++;
                if(count == k)
                {
                    list.add(sum);
                }
            }
            pq.add(sum);
        }
        int sum =0;

        if(pq.size()==1)
        {

            for(Integer el:list)
                sum += el;
            return sum;
        }
        else
            return -1;

    }

    public static void main(String[] args) {
        int[] a ={3,2,4,1};
        int k = 2;
        System.out.println(mergeStones(a,k));
    }
}
