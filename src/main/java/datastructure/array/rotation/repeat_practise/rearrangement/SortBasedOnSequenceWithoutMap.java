package datastructure.array.rotation.repeat_practise.rearrangement;

import java.util.Arrays;

public class SortBasedOnSequenceWithoutMap {
    public static void main(String[] args) {
        int[] a = { 2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        int[] b = {2, 1, 8, 3};
        int m = a.length;
        int n = b.length;
        sortAccordingly(a,b,m,n);
        System.out.println(Arrays.toString(a));
    }
    public static int first(int[] a,int lo,int hi, int x)
    {
        if(hi<lo)
            return -1;
        int mid = lo +(hi-lo)/2;
        if(mid == 0 || a[mid] ==x && x > a[mid-1])
            return mid;
        if( x > a[mid])
            return first(a,mid+1,hi,x);
        return first(a,lo,mid-1,x);
    }
    public static void sortAccordingly(int[] a,int[] b ,int m,int n)
    {
        int temp [] = new int[m];
        int visited[] = new int[m];

        for(int i=0;i<m;i++)
        {
            temp[i] = a[i];
            visited[i] =0;
        }

        Arrays.sort(temp);
        int index=0;
        for(int i=0;i<n;i++)
        {
            int f = first(temp,0,m-1,b[i]);
            if(f ==-1)
                continue;

            for(int j=f;j<m && temp[j] ==b[i] ;j++)
            {
                a[index++] = temp[j];
                visited[j] = 1;
            }
        }

            for(int i = 0;i<m ;i++)
            if(visited[i] ==0)
                a[index++] = temp[i];

    }
}
