package datastructure.array.pracitise.array.rotation;

public class CountRotationInSortedRotated {
    public static void main(String[] args) {
        int[] a = {5, 6, 1, 2,3,4};
        countRotation(a, 0, a.length - 1);
    }

    public static void countRotation(int[] a, int l, int h) {
        if(h==l)
        {
            System.out.println(a[h]);
            return;
        }
        if(h<l)
        {
            System.out.println(" no rotation");
            return;
        }
        else
        {
            int mid = (l+h)/2;
            if(mid>l && a[mid]<a[mid-1])
            {
                System.out.println(mid);
                return;

            }
            else if ( mid<h && a[mid]>a[mid+1])
            {
                System.out.println(mid+1);
                return;
            }
            if(a[mid]<a[h])
                 countRotation(a,l,mid-1);
            countRotation(a,mid+1,h);
        }
    }
}
