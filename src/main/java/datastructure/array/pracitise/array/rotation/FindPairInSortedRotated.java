package datastructure.array.pracitise.array.rotation;

public class FindPairInSortedRotated {
    public static void main(String[] args) {
        int[] a ={11, 15, 6, 7, 9, 10};
        int sum = 16;
        findPairSume(a,sum);
    }
    public static void findPairSume(int[] a,int sum)
    {
        int i=0;
        int n = a.length;
        for(;i<n;i++)
            if(a[i+1]<a[i])
                break;

        int l = (i+1)%n;
        int r = i;
        int count =0;
        while(l!= r)
        {
            if(a[l]+a[r] == sum)
            {
                count++;
                if(l == (r+n-1)%n)
                {
                    System.out.println(count);
                    return;
                }
                l = (l+1)%n;
                r = (n+r-1)%n;

            }
            else if ( a[l]+a[r] <sum)
                l = (l+1)%n;
            else
                r = (n+r-1)%n;
        }
        System.out.println(count);

    }
}
