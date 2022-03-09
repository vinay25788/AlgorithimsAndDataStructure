package datastructure_pattern.slidingwindow;

public class MaxConsecutive1s {
    static public int longestOnes(int[] nums, int k) {

        int i=0,j=0, zeroCount =0,maxLength =Integer.MIN_VALUE;

        int n = nums.length;

        while(j<n)
        {
            if(nums[j] == 0)
                zeroCount++;
            while(zeroCount>k)
            {
                if(nums[i] ==0)
                    zeroCount--;
                i++;
            }
            maxLength = Math.max(maxLength,(j-i+1));
            j++;
        }
        return maxLength;

    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k=2;
        System.out.println(longestOnes(nums,k));
    }
}
