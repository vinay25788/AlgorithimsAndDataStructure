package datastructure.binarysearch;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterEle {
    static  public int[] nextGreaterElements(int[] nums) {

        Stack<Integer> st = new Stack<>();
        int[] res = new int[nums.length];

        for(int i= nums.length-1;i>=0;i--)
        {
            while(!st.isEmpty() && st.peek()<=nums[i])
                st.pop();
            st.push(nums[i]);
        }

        for(int i=nums.length-1;i>=0;i--)
        {
            while(!st.isEmpty() && st.peek()<= nums[i])
                st.pop();
            if(st.isEmpty())
            {
                res [i] =-1;
                st.push(nums[i]);
            }
            else
            {
                res[i] = st.peek();
                st.push(nums[i]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] a ={1,2,3,4,3};
        System.out.println(Arrays.toString(nextGreaterElements(a)));
    }

}
