package datastructure.array.rotation.repeat_practise.rearrangement;

import java.util.Arrays;

public class MergeKSortedArrayEqualNumberElement {
    public static void main(String[] args) {
        int[][] a = new int[][]
                {{2, 6, 12, 34},
                        {1, 9, 20, 1000},
                        {23, 34, 90, 2000}};

        int n = a[0].length;
        int[] out = new int[n*a.length];
        mergeKArray(a,0,2,n,out);
        System.out.println(n);

        System.out.println(Arrays.toString(out));
    }

    public static void mergeKArray(int[][] a,int i,int j,int n ,int[] out)
    {
        if(i==j)
        {
            for(int p=0;p<n;p++)
                out[p] = a[i][p];
            return;
        }
        if(j-i==1)
        {
            merge(a[i],a[j],n,n,out);
            return;
        }
        int[] out1 = new int[n * ((n*(i+j)/2) -i +1)];
        int[] out2 = new int[n * (n*j-((i+j)/2))];
        mergeKArray(a,i,(i+j)/2,n,out1);
        mergeKArray(a,(i+j)/2+1, j,n,out2);

        merge(out1,out2, (n*((i+j)/2-i+1)), (n *(j-((i+j)/2))),out);

    }

    public static void merge(int[] a,int[] b,int n,int m,int[] out)
    {
        int i=0,j=0,k=0;
        while(i<n && j< m)
        {
            if(a[i]<b[j])
            out[k++] = a[i++];
            else
                out[k++] = b[j++];
        }
        while(i<n)
            out[k++] = a[i++];
        while(j<m)
            out[k++] = b[j++];
    }

}
