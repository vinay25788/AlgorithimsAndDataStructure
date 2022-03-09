package datastructure.binarysearch;

public class AllocateNumberOfPages {
    public static void main(String[] args) {
        int[] a ={10,20,30,40};
        int k = 2;
        System.out.println(findMinPages(a,k));
    }

    public static int findMinPages(int[] a,int k)
    {
        int max =0;
        int sum = 0;
        for(int i=0;i<a.length;i++)
        {
            sum +=a[i];
            if(max<a[i])
                max = a[i];
        }

        int start = max;
        int end = sum;
        int n = a.length;
        int res = -1;

        while(start<= end)
        {
            int mid = start +(end- start)/2;

            if(isValid(a,n,k,mid))
            {
                res = mid;
                end = mid-1;
            }
            else
                start = mid+1;

        }

        return res;
    }

    public static boolean isValid(int[] a,int n,int k,int mid)
    {
        int student = 1;
        int sum =0;
        for(int i=0;i<n;i++)
        {
            sum +=a[i];
            if(sum>mid)
            {
                student++;
                sum = a[i];
            }
            if(student>k)
                return false;

        }
        return true;
    }
}
