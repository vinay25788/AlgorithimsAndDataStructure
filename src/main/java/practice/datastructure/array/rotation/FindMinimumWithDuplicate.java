package practice.datastructure.array.rotation;

public class FindMinimumWithDuplicate {
    public static void main(String[] args) {
        int[] a = {3,3,3,4,5,2};
        System.out.println(findMin(a,0,a.length-1));
    }
    public static int findMin(int[] a,int l,int h)
    {
        if(h<l)
            return a[0];
        if(h==l)
            return a[l];
        int mid = (l+h)/2;
        if(a[mid] == a[l] && a[h] == a[mid])
        {
            l++;
            h--;
            return findMin(a,l,h);
        }
        if(mid>l && a[mid-1]>a[mid])
            return a[mid];
        if(mid<h && a[mid+1]<a[mid])
            return a[mid+1];
        if(a[h]>a[mid])
            return findMin(a,l,mid-1);
        return findMin(a,mid+1,h);
    }
}
