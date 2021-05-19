package datastructure.array.rotation.repeat_practise.rotation;

public class FindMinimumInSortedRotatedArray {
    public static void main(String[] args) {
        int[] a = new int[]{2,1};
        System.out.println(" minimum element "+findMinimum(a,0,a.length-1));
    }
    public static int findMinimum(int[] a,int l,int h)
    {
        if(h<l)
            return a[0];
        if(h==l)
            return a[l];
        int mid = (h+l)/2;
        if(mid < h && a[mid]>a[mid+1])
            return a[mid+1];
        if( mid>l && a[mid]< a[mid-1])
            return a[mid];
        if(a[mid]<a[h])
            return findMinimum(a,l,mid-1);
        return findMinimum(a,mid+1,h);

    }
}
