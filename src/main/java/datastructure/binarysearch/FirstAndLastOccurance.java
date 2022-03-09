package datastructure.binarysearch;

public class FirstAndLastOccurance {
    public static int[] searchRange(int[] nums, int target) {

        int start =0;
        int end = nums.length-1;

        int first = searchFirstOccurance(nums,start,end,target);
        int second = searchSecondOccurance(nums,start,end,target);

        return new int[]{first,second};

    }


    private static int searchFirstOccurance(int[] nums,int start,int end,int target)
    {
        int res =-1;

        while(start<=end)
        {
            int mid = start + (end-start)/2;
            if(nums[mid] == target)
            {
                res = mid;
                end = mid-1;
            }
            else if ( target<nums[mid])
                end = mid-1;
            else
                start = mid+1;
        }

        return res;
    }

    private static int searchSecondOccurance(int[] nums,int start,int end,int target)
    {
        int res =-1;

        while(start<=end)
        {
            int mid = start + (end-start)/2;
            if(nums[mid] == target)
            {
                res = mid;
                start = mid+1;
            }
            else if ( target<nums[mid])
                end = mid-1;
            else
                start = mid+1;
        }

        return res;
    }

    public static void main(String[] args) {
        int [] a = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(searchRange(a,target));
    }
}
