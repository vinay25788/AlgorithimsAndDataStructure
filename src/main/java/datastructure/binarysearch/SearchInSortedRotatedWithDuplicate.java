package datastructure.binarysearch;

public class SearchInSortedRotatedWithDuplicate {
    public static boolean search(int[] nums, int target) {

        int start =0;
        int end = nums.length-1;

        return findTarget(nums,start,end,target);
    }

    private static boolean findTarget(int[] nums,int start,int end,int target)
    {
        if(start>end)
            return false;
        int mid = start + (end - start)/2;

        if(nums[mid] == target)
            return true;
        if(mid>1 && nums[mid-1] == target)
            return true;
        if(mid<end-1 && nums[mid+1] == target)
            return true;

        if(nums[start]<=nums[mid])
        {
            if(target >= nums[start] && target <= nums[mid])
                return findTarget(nums,start,mid-1,target);
            else
                return findTarget(nums,mid+1,end,target);
        }
        else
        {
            if(target> nums[mid] && target < nums[end])
                return findTarget(nums,mid+1,end,target);
            else
                return findTarget(nums,start,mid-1,target);
        }
    }

    public static void main(String[] args) {
    int [] a ={1,3,5};
    int target =1;
        System.out.println(search(a,target));
    }
}
