package datastructure.array.range_query_question;

import java.util.Arrays;
import java.util.Comparator;

public class MergeInterval {
    static class Interval
    {
        int start,end;
        public Interval(int start,int end)
        {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Interval[] a = new Interval[4];
        a[0]=new Interval(6,8);
        a[1]=new Interval(1,9);
        a[2]=new Interval(2,4);
        a[3]=new Interval(4,7);
        mergeInterval(a);
    }

    public static void mergeInterval(Interval[] a)
    {
        Arrays.sort(a, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });

        int index =0,n = a.length;
        for(int i=1;i<n;i++)
        {
            if(a[index].end>=a[i].end)
            {
                a[index].end = Math.max(a[index].end,a[i].end);
                a[index].start = Math.min(a[index].start,a[i].start);
            }
            else
            {
                index++;
                a[index] = a[i];
            }
        }

        System.out.println(" merged index ");
        for(int i=0;i<=index;i++)
            System.out.println(a[i].start+" , "+a[i].end);
    }
}
