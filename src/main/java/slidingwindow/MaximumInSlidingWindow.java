package slidingwindow;

import java.util.*;

public class MaximumInSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {


        int n = nums.length;

        int[] res = new int[n-k+1];


        Deque<Integer> dq = new LinkedList<>();

        for(int i=-0;i<n;i++)
        {
            while(dq.size()>0 && nums[i]>=nums[dq.getLast()]) dq.removeLast();
            dq.addLast(i);
            if((i-k+1)>=0) res[i-k+1] = nums[dq.getFirst()];
            if((i-k+1)>= dq.getFirst()) dq.removeFirst();

        }

        return res;

    }

    public static void main(String[] args) {
        int[] a ={1,3,-1,-3,5,3,6,7};
        int k =3;
        System.out.println(Arrays.toString(maxSlidingWindow(a,k)));
    }

}
