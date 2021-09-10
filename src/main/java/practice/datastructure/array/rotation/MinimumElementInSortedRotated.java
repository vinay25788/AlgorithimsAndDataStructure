package practice.datastructure.array.rotation;

public class MinimumElementInSortedRotated {
    public static void main(String[] args) {
        int[] a = {5,6,7,2,3};// {3,4,5,6,1,2}
        System.out.println(" minimum element "+minimumElement(a,0,a.length-1));
    }

    public static int minimumElement(int[] a,int l,int h)
    {
        if(h<l)
            return a[0];
        if(l==h)
            return a[l];
        int mid = (l+h)/2;
        if(mid>l && a[mid]<a[mid-1])
            return a[mid];
        if(mid<h && a[mid+1]<a[mid])
            return a[mid+1];
        if(a[h]>a[mid])
            return minimumElement(a,l,mid-1);
        return minimumElement(a,mid+1,h);
    }
}
