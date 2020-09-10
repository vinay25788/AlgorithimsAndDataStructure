package datastructure.array.searching_and_sorting;

public class FindPairCountInSortedRotated {
    public static void main(String[] args) {
        int[] a= {7,8,9,1,2,3,4,5,6};
        int sum = 10;
        System.out.println(countPairSum(a,sum));
    }
    private static int countPairSum(int[] a,int sum)
    {
        int count=0;
        int i;
        int n = a.length;
        for(i=0;i<a.length;i++)
        {
            if(a[i]>a[i+1])
                break;
        }

        int l = (i+1)%n;
        int r = i;

        while(l != r)
        {
            if(l == (r-1+n)%n)
                return count;

            if(a[l]+a[r] == sum)
            {
                count++;
                l = (l+1) %n;
                r = (r-1+n)%n;
            }
            else if ( a[l] +a[r ]< sum)
                l = (l+1)%n;
            else
                r = (r - 1 +n )%n;
        }

        return count;
    }
}
