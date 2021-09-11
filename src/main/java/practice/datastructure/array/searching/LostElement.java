package practice.datastructure.array.searching;

public class LostElement {
    public static void main(String[] args) {
        int a[] = { 4, 1, 5, 9, 7 };
        int a2[] = { 1,7, 5, 9 };
        lostElement(a,a2);
        lostElementUsingBinarySearch(a,a2);
    }
    public static void lostElement(int[] a,int[] b)
    {
        int n = a.length;
        int m = b.length;

        int xor = a[0]  ;

        for(int i=1;i<n;i++)
            xor ^=a[i];
        for(int i=0;i<m;i++)
            xor ^= b[i];

        System.out.println(xor);
    }
    public static void lostElementUsingBinarySearch(int[] a,int[] b)
    {

        int n = a.length;
        int m = b.length;
        if(n == m-1)
            findMissingUtil(b,a,m);
        else if ( n-1 == m)
            findMissingUtil(a,b,n);
        else
        {
            System.out.println(" wrong input ");
            return;
        }
    }

    public static void findMissingUtil(int[] a,int [] b, int len)
    {
        if(len==1)
        {
            System.out.println(a[0]);
            return;
        }
        if(a[0] != b[0])
        {
            System.out.println(a[0]);
            return;
        }
        int l = 0,h= len-1;

        while(l<h)
        {
            int mid = (l+h)/2;
            if(a[mid] == b[mid])
                l = mid;
            else
                h = mid;
            if(l==h-1)
                break;
        }

        System.out.println(a[h]);

    }
}
