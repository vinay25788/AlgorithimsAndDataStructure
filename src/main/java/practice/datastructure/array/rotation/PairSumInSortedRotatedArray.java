package practice.datastructure.array.rotation;

public class PairSumInSortedRotatedArray {
    public static void main(String[] args) {
        int[] a  = {3,4,5,6,1,2};
        int sum = 6;
        int minimumIndex = minimumElementIndex(a,0,a.length-1);
        System.out.println(minimumIndex);
        int l = minimumIndex;
        int h = minimumIndex-1;
        int count =0;
        int n = a.length;
        while(h!=l)
        {
            if(a[h]+a[l] == sum)
            {
                count++;
                if(l == (h -1+n)%n)
                {
                    System.out.println(count);
                    break;
                }
                l = (l+1)%n;
                h = (h-1)%n;
            }
            else if ( a[h]+a[l]<sum)
                l = (l+1) % n;
            else
                h = (h-1)%n;
        }
        System.out.println(count);
    }
    public static int minimumElementIndex(int[] a,int l,int h)
    {
        if(h<l)
            return a[0];
        if(l==h)
            return a[l];
        int mid = (l+h)/2;
        if(mid>l && a[mid] <a[mid-1])
            return mid;
        if(mid<h && a[mid+1]<a[mid])
            return mid+1;
        if(a[h]>a[mid])
            return minimumElementIndex(a,l,mid-1);
        return minimumElementIndex(a,mid+1,h);
    }
}
