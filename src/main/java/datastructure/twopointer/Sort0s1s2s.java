package datastructure.twopointer;

import java.util.Arrays;

public class Sort0s1s2s {

    static public void sortColors(int[] nums) {

        int s =0, e= nums.length-1;

        int n = nums.length;

        int k =0;


        for(int i=0;i<e;)
        {
            if(   nums[i] == 0)
            {
                int temp = nums[i];
                nums[i] = nums[s];
                nums[s] = temp;
                s++;
               i++;
             }
            else if( nums[i] == 1)
                i++;
            else
            {
                int temp = nums[i];
                nums[i] = nums[e];
                nums[e] =temp;
                e--;
            }
        }

        System.out.println(Arrays.toString(nums));


    }

    public static void main(String[] args) {
        int[] a ={2,0,2,1,1,0};
       sortColors(a);
    }
}
