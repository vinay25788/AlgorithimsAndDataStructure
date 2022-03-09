package datastructure.grokking_slidingwindow;

import java.util.Arrays;

public class LargestSubArrayLengthK {
    static public int[] largestSubarray(int[] nums, int k) {
        int maxId=0;
        for(int i=0;i<=nums.length-k;i++)
            maxId = nums[maxId]> nums[i] ? maxId:i;

        int[] res = new int[k];
        int id=0;
        for(int i=maxId;i<maxId+k;i++)
            res[id++] = nums[i];
        return res;


    }

    public static void main(String[] args) {
        int[] a ={1,4,5,2,3};
        int k = 3;
        System.out.println(Arrays.toString(largestSubarray(a,k)));
    }
}
