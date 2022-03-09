package datastructure.twopointer;

import java.util.Arrays;

public class TripletClosestSum {

    static  public int threeSumClosest(int[] nums, int target) {

        if(nums.length<3)
            return 0;
        Arrays.sort(nums);

        int smallestDifference = Integer.MAX_VALUE;
        int nearestSum = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(i>0 && nums[i] == nums[i-1])
                continue;

            int j = i+1;
            int k = nums.length-1;


            while(j<k)
            {
                int sum = nums[i] + nums[j] + nums[k];

                int diff = Math.abs(target - sum);

                if (diff < smallestDifference)
                {
                    smallestDifference = diff;
                    nearestSum = sum;
                }


                if( diff == 0)
                {
                    break;
                }
                else if(sum < target)
                    j++;
                else
                    k--;


            }

            if(smallestDifference == 0)
                break;
        }

        return nearestSum;
    }

    public static void main(String[] args) {
        int[] a ={-1,2,1,-4};
        int k =1;
        System.out.println(threeSumClosest(a,k));
    }
}
