package datastructure.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSum {
    public static void main(String[] args) {
        int[] a ={-1,0,1,2,-1,-4};
        System.out.println(threeSum(a));
    }
     static public List<List<Integer>> threeSum(int[] nums) {
        if( nums.length < 3)
            return new ArrayList<>();

        List<List<Integer>> list = new ArrayList<>();

        int n = nums.length;

        for(int i=0;i<=n-3;i++)
        {
            if(i>0 && nums[i] == nums[i-1])
            {

                continue;
            }

            int j = i+1;
            int k = n-1;
            int targetSum = -1* nums[i];




            while(j<k)
            {
                int sum = nums[j]+nums[k];


                if(sum == targetSum)
                {
                    List<Integer> triplet = new ArrayList<>();

                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);

                    j++;
                    k--;
                    list.add(triplet);
                    while(j<k && nums[j]== nums[j-1]) j++;
                    while(k>j && nums[k] == nums[k+1]) k--;
                }
                else if(sum>targetSum)
                    k--;
                else
                    j++;

            }
        }

        return list;
    }
}
