package practice.datastructure.array.arrangement;

public class SortedSubseqenceOfSize3 {
    public static void main(String[] args) {
        int[] nums = {1,2,-1,7,5};
        findSubSequence(nums);
    }
    public static void findSubSequence(int[] nums)
    {
        int n = nums.length;
        if(n<3)
        {
            System.out.println(" length should be greater than 3");
            return;
        }
        int maxSeq = Integer.MIN_VALUE;
        int minNum = nums[0];
        int storeMin = minNum;
            int seq =1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i] == minNum)
                continue;
            else if (nums[i]<minNum)
            {
                minNum = nums[i];
                continue;
            }
            else if(nums[i]<maxSeq)
            {
                maxSeq = nums[i];
                storeMin = minNum;
            }
            else if(nums[i]>maxSeq)
            {

            seq++;
                 if(seq == 3)
                {
                     System.out.println(" triplet "+storeMin+" , "+maxSeq+" , "+nums[i]);
                    return;
                 }
            maxSeq = nums[i];

            }
        }
        System.out.println(" no such triple found ");
    }
}
