package practice.datastructure.array.arrangement;

import java.util.Arrays;

public class ReArrangeHighestLowestPattern {
    public static void main(String[] args) {
        int[] a ={1,2,3,4,5,6};
        reArrange(a);
        int[] ar = {4,6,8,10};
        arrange(ar);
    }
    public static void arrange(int[] a)
    {
        int n = a.length;
        int maxId = n-1,minId =0;
        int maxEle = a[maxId]+1;
        for(int i=0;i<n;i++)
        {
            if(i%2==0)
            {
                a[i]+=(a[maxId--]%maxEle)*maxEle;
            }
            else
                a[i]+=(a[minId++]%maxEle)*maxEle;
        }

        for(int i=0;i<n;i++)
        {
            a[i] /= maxEle;
        }
        System.out.println(" with 1 extra space ");
        System.out.println(Arrays.toString(a));
    }
    // ReArrange with space complexity n
    public static void reArrange(int[] a)
    {
        int n = a.length;
        int[] temp = a.clone();
        boolean flag = true;
        int smallest =0, highest = n-1;
        for(int i=0;i<n;i++)
        {
            if(flag)
                a[i] = temp[highest--];
            else
                a[i] = temp[smallest++];
            flag = !flag;
        }
    }
}
