package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class MinimumDifferenceSubsetSum {
    public static void main(String[] args) {
        int[] a = {1, 6, 11, 8};
        System.out.println(minimumDifference(a));
    }

    public static int minimumDifference(int[] a)
    {
        int sum =0;
        for(int i=0;i<a.length;i++)
            sum+=a[i];

        List<Integer> list = getSubsetS1(a,sum);

        int min = Integer.MAX_VALUE;

        for(int i=0;i<list.size();i++)
            min = Math.min(min,sum - 2* list.get(i));

        return min;
    }


    public static List<Integer> getSubsetS1(int[] a,int sum)
    {
        boolean[][] t = new boolean[a.length+1][sum+1];

        for(int i=0;i<a.length+1;i++)
        {
            for(int j=0;j<sum+1;j++)
            {
                if(i==0)
                    t[i][j] = false;
                if(j==0)
                    t[i][j] = true;
            }
        }

        List<Integer> list = new ArrayList<>();

        for(int i=1;i<a.length+1;i++)
        {
            for(int j=1;j<sum+1;j++)
            {
                if(a[i-1]<=j)
                    t[i][j] = t[i-1][j-a[i-1]] || t[i-1][j];
                else
                    t[i][j] = t[i-1][j];

                if(i== a.length && j<= sum/2 && t[i][j])
                    list.add(j);
            }
        }

        return list;
    }
}

