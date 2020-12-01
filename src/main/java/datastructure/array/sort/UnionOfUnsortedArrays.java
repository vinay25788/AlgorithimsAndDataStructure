package datastructure.array.sort;

import java.util.Arrays;

public class UnionOfUnsortedArrays {
    public static void main(String[] args) {
        int a1[] = { 7, 1, 5, 2, 3, 6 };
        int a2[] = { 3, 8, 6, 20, 7 };
        findUnion(a1,a2);
    }
    public static void findUnion(int[] a1,int[] a2) {
        int m = a1.length;
        int n = a2.length;
        if (m > n) {
            int temp[] = a1;
            a1 = a2;
            a2 = temp;
            int leng = m;
            m = n;
            n = leng;
        }

        Arrays.sort(a1);
        for (int a : a1)
            System.out.print(" "+a);
        for(int i=0;i<n;i++)
        {
            if(binarySearch(a1,0,m,a2[i])==-1)
                System.out.print(" "+a2[i]);
        }

    }

    public static int binarySearch(int[] a, int l, int h, int key)
    {
        if(l>h)
            return -1;
        if(l<=h)
        {
            int mid  = (l+h)/2;
            if(a[mid] == key)
                return mid;
            if(a[mid]>key)
                return binarySearch(a,l,mid-1,key);
            return binarySearch(a,mid+1,h,key);

        }
        return -1;
    }

}
