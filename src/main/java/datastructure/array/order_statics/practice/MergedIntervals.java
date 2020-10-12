package datastructure.array.order_statics.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

class Interval
{
    int start,end;
    Interval(int start,int end)
    {
        this.start = start;
        this.end = end;
    }
}
public class MergedIntervals {
    public static void main(String[] args) {
        Interval arr[]=new Interval[4];
        arr[0]=new Interval(6,8);
        arr[1]=new Interval(1,9);
        arr[2]=new Interval(2,4);
        arr[3]=new Interval(4,7);
        mergeIntervals(arr);
    }
    public static void mergeIntervals(Interval[] arr)
    {
        int n=arr.length;
        if(n<=0)
            return;

        Arrays.sort(arr, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });

        Stack<Interval> stack = new Stack<>();
        stack.push(arr[0]);

        for(int i=1;i<n;i++)
        {
            Interval top = stack.peek();
            if(top.end < arr[i].start)
                top.end = arr[i].start;

            else if (top.end < arr[i].end)
            {
                top.end = arr[i].end;
                stack.pop();
                stack.push(top);

            }
        }

        System.out.println("merged intervals ");
        while(!stack.isEmpty())
        {
            Interval top = stack.pop();
            System.out.println(" "+top.start+" "+top.end);
        }
    }
}
