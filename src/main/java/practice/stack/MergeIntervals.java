package practice.stack;



import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MergeIntervals {

    static class Interval
    {
        int start;
        int end;
        Interval(int start,int end)
        {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Interval[] arr= new Interval[4];
        arr[0]=new Interval(6,8);
        arr[1]=new Interval(1,9);
        arr[2]=new Interval(2,4);
        arr[3]=new Interval(4,7);
        mergeIntervals(arr);
    }

    private static void mergeIntervals(Interval[] arr)
    {

        Arrays.sort(arr, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        int ind = 0;
        for (int i =1;i<arr.length;i++)
        {
            if(arr[ind].end>= arr[i].start)
            {
                arr[ind].end = Math.max(arr[ind].end,arr[i].end);
                arr[ind].start = Math.min(arr[ind].start,arr[i].start);
            }
            else
            {
                ind++;
                arr[ind] = arr[i];
            }
        }

        for(int i=0;i<=ind;i++)
            System.out.print(arr[i].start+"  "+arr[i].end);
    }
}
