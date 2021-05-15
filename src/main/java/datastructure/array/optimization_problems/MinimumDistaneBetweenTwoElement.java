package datastructure.array.optimization_problems;

public class MinimumDistaneBetweenTwoElement {
    public static void main(String[] args) {
        int[] a={3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
        int first = 3;
        int second = 6;
        findMinDistance(a,first,second);
    }
    public static void findMinDistance(int[] a,int first,int second)
    {
        int minDistance = Integer.MAX_VALUE;
        int n = a.length;
        int prev=-1;
        for(int i=0;i<n;i++)
        {
            int x = a[i];

            if( x == first || x == second)
            {
                if( prev != -1 && a[prev] != a[i])
                {
                    minDistance = Math.min(minDistance,i-prev);
                }
                prev = i;

            }
        }
        System.out.println( " mindistance "+minDistance);

    }
}
