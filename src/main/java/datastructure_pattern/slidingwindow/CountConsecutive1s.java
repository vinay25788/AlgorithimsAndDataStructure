package datastructure_pattern.slidingwindow;

public class CountConsecutive1s {
    static public int findMaxConsecutiveOnes(int[] nums) {
        int i=0,j=0,count1s =0,maxLength =0;

        int n = nums.length;

        while(j<n)
        {
            if(nums[j] ==1)
                count1s++;
            if( (j-i+1) > count1s )
            {
                maxLength = Math.max(maxLength,count1s);

                if(nums[j] == 0)

                {
                    count1s=0;
                    i =j;
                }

            }
            j++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] a ={1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(a));
    }
}
