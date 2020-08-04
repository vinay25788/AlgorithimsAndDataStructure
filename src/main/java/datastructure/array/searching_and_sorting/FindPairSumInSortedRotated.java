package datastructure.array.searching_and_sorting;

public class FindPairSumInSortedRotated {
    public static void main(String[] args) {
        int[] a={3,4,5,1,2};

        int sum = 5;
        System.out.println(findSum(a,sum));
        System.out.println(String.format("%s hello","vinay"));

    }

    public static boolean findSum(int[] a,int sum)
    {
        int i;
        int n = a.length-1;
        for( i=0;i<n-1;i++)
            if(a[i]>a[i+1]);
            int low = i+1;
            int high = i;
            while(low!=high)
            {
                if(a[low]+a[high] == sum)
                    return true;
                if(a[low]+a[high]< sum)
                    low = (low+1) % n;
                else
                    high = (high+n-1) % n;
            }
            return false;
    }
}
