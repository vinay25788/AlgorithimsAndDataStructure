package practice.datastructure.array.rotation;

public class FindTheRotationCount {
    public static void main(String[] args) {
        int[] a = {15, 18, 2, 3, 6, 12};
        System.out.println(rotationCount(a,0,a.length-1));

    }
    public static int rotationCount(int[] a,int l,int h)
    {
        if(h<l)
            return 0;
        int mid = (h+l)/2;
        if(mid>l && a[mid]<a[mid-1])
            return mid;
        if(mid<h && a[mid+1]<a[mid])
            return mid;
        if(a[h]>a[mid])
        {
            return rotationCount(a,l,mid-1);
        }
        else
            return rotationCount(a,mid+1,h);
    }

}
