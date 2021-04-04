package datastructure.array.rotation.repeat_practise;

public class PairInSortedRotatedArray {
    public static void main(String[] args) {
        int[] a = new int[]{11, 15, 6, 7, 9, 10};
        int x=18;
        System.out.println(" pair count "+findPair(a,x));
    }
    public static int findPair(int[] a,int x)
    {
        int i;
        int n = a.length;
        for(i=0;i< n-1;i++)
            if(a[i]>a[i+1])
                break;

        int l = (i+1)%n;
        int r = i;
        int count = 0;
        while(l!=r)
        {
            if(a[l]+a[r]== x)
            {
                count++;
                if(l == ( r-1+n)%n)
                    return count;

                l = (l+1)%n;
                r = ( r-1+n)%n;

            }
            else if ( a[l]+a[r]<x)
                l = (l+1)%n;
            else
                r = (r-1+n)%n;
        }
        return count;
    }
}
