package datastructure.array.optimize;

public class LargestSumSubArrayIndexes {
    public static void main(String[] args) {
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        sum(a);
    }
    public static void sum(int[] a)
    {
        int n = a.length;
        int max_so_far=0,curr_sum=0,start =0,end =0,s=0;

        for(int i=0;i<n;i++)
        {
            curr_sum = curr_sum+a[i];
            if(max_so_far<curr_sum)
            {
                max_so_far =curr_sum;
                start = s;
                end = i;
            }
            if( curr_sum<0)
            {
                curr_sum =0;
                s = i+1;
            }
        }

        System.out.println("largest sub array sum "+max_so_far+"  from index "+start+" ending index "+end);
    }
}
