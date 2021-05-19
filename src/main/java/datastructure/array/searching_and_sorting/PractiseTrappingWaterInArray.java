package datastructure.array.searching_and_sorting;

public class PractiseTrappingWaterInArray {
    public static void main(String[] args) {
        int a[] = { 0, 1, 0, 2, 1, 0, 1,
                3, 2, 1, 2, 1 };
        findWater(a);
    }
    public static void findWater(int[] a)
    {
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        int n= a.length;
        int lo=0,h =n-1;
        int result =0;
        while( lo<=h)
        {
            if(a[lo]<a[h])
            {
                if(leftMax<a[lo])
                    leftMax = a[lo];
                else
                    result += leftMax-a[lo];
                lo++;
            }
            else
            {
                if(rightMax<a[h])
                {
                    rightMax = a[h];
                }
                else
                    result+=rightMax-a[h];
                h--;
            }
        }
        System.out.println(result);
    }
}
