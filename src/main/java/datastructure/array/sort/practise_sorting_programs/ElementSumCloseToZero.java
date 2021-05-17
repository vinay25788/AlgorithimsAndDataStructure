package datastructure.array.sort.practise_sorting_programs;

public class ElementSumCloseToZero {
    public static void main(String[] args) {
        int[] a = {1, 60, -10, 70, -80, 85};
        findElement(a);
    }

    public static void findElement(int[] a) {
        int n = a.length;
        int first =0,second =0;
        for (int i = 1; i < n; i++) {
            if (!(Math.abs(a[i - 1]) < Math.abs(a[i]))) {
                int temp = a[i - 1];
                a[i - 1] = a[i];
                a[i] = temp;
            }
        }
        int minDist = Integer.MAX_VALUE;

        for(int i=1;i<n;i++)
        {
            if(Math.abs(a[i-1]+a[i])<=minDist)
            {
                minDist = Math.abs(a[i-1]-a[i]);
                first = a[i];
                second = a[i-1];
            }
        }
        System.out.println(minDist +" first "+first+" second "+second);
    }
}
