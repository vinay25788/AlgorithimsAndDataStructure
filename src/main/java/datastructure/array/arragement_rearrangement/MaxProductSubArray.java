package datastructure.array.arragement_rearrangement;

public class MaxProductSubArray {
    public static void main(String[] args) {
        int a[] = { 1, -2, -3, 0, 7, -8, -2 };
        System.out.println(findMaxProduct(a));
    }
    public static int findMaxProduct(int[] a)
    {
        int max_so_far =0;
        int max=1,min=1;
        int flag =0;
        int n = a.length;

        for(int i=0;i<n;i++)
        {
            if(a[i] > 0)
            {
                max = max*a[i];
                min = Math.min(min*a[i],1);
            }
            else if ( a[i] ==0)
            {
                max =1;
                min =1;
            }
            else
            {
                int temp = max;
                max = Math.max(min*a[i],1);
                min = temp*a[i];
            }

            if(max_so_far<max)
                max_so_far = max;

        }
        return max;
    }
}
