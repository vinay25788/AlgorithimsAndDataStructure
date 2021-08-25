package datastructure.array.pracitise.array.arrangement;

import java.util.Arrays;

public class ReArrangeMaxMinimum {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8};
        reArrange(a);
    }
    public static void reArrange(int[] a)
    {
        int maxId = a.length-1;
        int minId = 0;
        int maxEle = a[maxId]+1;
        for(int i=0;i<a.length;i++)
        {
            if(i%2 == 0)
            {
                a[i] += (a[maxId] % maxEle) * maxEle;
                maxId--;
            }
            else
            {
                a[i] += (a[minId]%maxEle)* maxEle;
                minId++;
            }
        }
        for(int i=0;i<a.length;i++)
            a[i] = a[i] /maxEle;

        System.out.println(Arrays.toString(a));
    }
}
