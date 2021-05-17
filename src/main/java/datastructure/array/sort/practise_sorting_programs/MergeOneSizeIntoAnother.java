package datastructure.array.sort.practise_sorting_programs;

import java.util.Arrays;

public class MergeOneSizeIntoAnother {
    public static void main(String[] args) {
        int mPlusN[] = { 2, 8, -1, -1, -1, 13, -1, 15, 20 };
        int N[] = { 5, 7, 9, 25 };
        moveToEnd(mPlusN);
        int n = N.length;
        merge(mPlusN,N,mPlusN.length-n,n);
    }
    public static void merge(int[] mPlusN,int[] N,int m,int n)
    {
        int i=n;
        int k=0;
        int j= 0;
        while(k<(m+n))
        {
            if(i<(m+n)&& mPlusN[i]<=N[j]|| (j==n))
            {
                mPlusN[k++] = mPlusN[i++];
            }
            else
            {
                mPlusN[k++] = N[j++];
            }
        }

        System.out.println(Arrays.toString(mPlusN));

    }
    public static void moveToEnd(int[] mPlusN)
    {
        int n = mPlusN.length;
        int j = n-1,i=n-1;
        while(j>=0)
        {
            if(mPlusN[j] != -1)
            {
                mPlusN[i] = mPlusN[j];
                i--;
            }
            j--;
        }

    }
}
