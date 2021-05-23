package datastructure.stack;

import java.util.Stack;

public class HistogramArea {

    static int getMaxArea(int[] hist)
    {
        int n = hist.length;
        Stack<Integer> st = new Stack<>();

        int max_area=Integer.MIN_VALUE;
        int tp;
        int areaWithTop;
        int i=0;
        while(i<n)
        {
            if(st.isEmpty() || hist[st.peek()]<=hist[i])
                st.push(i++);
            else
            {
                tp = st.pop();
                areaWithTop = hist[tp] * (st.isEmpty()? i: i-st.peek()-1);
                if(max_area<areaWithTop)
                    max_area = areaWithTop;
            }
        }
        while(!st.isEmpty())
        {
            tp = st.pop();
            areaWithTop = hist[tp] * (st.isEmpty()? i : i-st.peek()-1);
            if(max_area<areaWithTop)
                max_area = areaWithTop;

        }
        return max_area;
    }
    public static void main(String[] args) {
        int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
        System.out.println("Maximum area is " + getMaxArea(hist));

    }
}
