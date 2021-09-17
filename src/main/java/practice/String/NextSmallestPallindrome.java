package practice.String;

import java.util.Arrays;

public class NextSmallestPallindrome {
    public static void main(String[] args) {
        int[] nums = { 9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2 };
        nextSmallest(nums,nums.length);
    }
    private static void nextSmallest(int[] nums,int n)
    {
        if(all9(nums,n))
        {
            System.out.print("1 ");
            for(int i=0;i<n;i++)
                System.out.print("0 ");
            System.out.print("1");
        }
        else
            nextPossibleSmallestNumber(nums,n);
    }

    private static void nextPossibleSmallestNumber(int[] nums,int n)
    {
        int mid = n/2;
        int i = mid-1;
        int j = (mid%2 == 0 ? mid:mid+1);
        while(i>=0 && nums[i] == nums[j])
        {
            i--;
            j++;
        }
        boolean leftSmallest = false;

        if(i<=0 || nums[i]<nums[j])
            leftSmallest = true;
        while(nums[i]<nums[j])
        {
            nums[j++] = nums[i--];
        }
        if(leftSmallest)
        {
            int carry = 1;
            mid = ( n/2);
            if(n%2 == 1)
            {
                nums[mid] +=1;
                carry = nums[mid]/10;
                nums[mid] %=10;
            }

             i = mid-1;
            j =  ( mid %2 == 0 ? mid:mid+1);
            while(i>=0)
            {
                nums[i] += carry;
                carry = nums[i]/10;
                nums[i] %=10;
                nums[j] = nums[i];
                i--;
                j++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }
    private static boolean all9(int[] nums,int n)
    {
        for(int i=0;i<n;i++)
        {
            if(nums[i] != 9)
                return false;
        }
        return true;
    }
}
