package datastructure.array.sort;

import java.util.Arrays;

/*
Merge an array of size n into another array of size m+n
There are two sorted arrays. First one is of size m+n containing only m elements. Another one is of size n and contains
 n elements. Merge these two arrays into the first array of size m+n such that the output is sorted.
 */
public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int mPlusN[] = {2, 8, -1, -1, -1, 13, -1, 15, 20};
        int N[] = {5, 7, 9, 25};
        int n = N.length;
        int m = mPlusN.length-n;
        moveToEnd(mPlusN,m+n);
        merge(mPlusN,N,m,n);
        System.out.println(Arrays.toString(mPlusN));
    }
    public static void moveToEnd(int[] mPlusN,int m)
    {
        int i,j=m-1;
        for( i=m-1;i>=0;i--)
        {
            if(mPlusN[i] != -1)
            {
                mPlusN[j]  = mPlusN[i];
                j--;
            }

        }
    }

    public static void merge(int[] mPlusN,int[] N,int m,int n)
    {
        int i= n;
        int j=0;
        int k=0;

        while(k<(m+n))
        {
            if((i<(m+n) && mPlusN[i] <= N[j]) || (j==n))
            {
                mPlusN[k] = mPlusN[i];
                k++;i++;
            }
            else
            {
                mPlusN[k] = N[j];
                k++;j++;
            }
        }
    }
}
