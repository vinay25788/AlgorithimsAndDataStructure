package datastructure.array.sort.practise_sorting_programs;

import java.util.Arrays;

public class TwoElementSumCloseToZero {
    public static void main(String[] args) {
        int[] a ={1, 60, -10, 70, -80, 85 };
        findMinSum(a,a.length);
    }
    static void findMinSum(int[] arr, int n)
    {
        for(int i = 1; i < n; i++)
        {
            if (!(Math.abs(arr[i - 1]) <
                    Math.abs(arr[i])))
            {
                int temp = arr[i - 1];
                arr[i - 1] = arr[i];
                arr[i] = temp;
            }
        }

        System.out.println(Arrays.toString(arr));

        int min = Integer.MAX_VALUE;
        int x = 0, y = 0;

        for(int i = 1; i < n; i++)
        {

            // Absolute value shows how close
            // it is to zero
            if (Math.abs(arr[i - 1] + arr[i]) <= min)
            {

                // If found an even close value
                // update min and store the index
                min = Math.abs(arr[i - 1] + arr[i]);
                x = i - 1;
                y = i;
            }
        }
        System.out.println("The two elements whose " +
                "sum is minimum are " +
                arr[x] + " and " + arr[y]);
    }
    public static void findElement(int[] a)
    {
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        int l=0, r = a.length-1;
        int minSum = Integer.MAX_VALUE;
        int first = 0, second =0,n = a.length;

        for(int i=1;i<n;i++)
        {
            if(Math.abs((a[i]-a[i-1])) < minSum)
            {
                minSum = Math.abs(a[i]-a[i-1]);
                first = a[i-1];
                second = a[i];
            }

        }
        System.out.println(minSum+"  first "+first+" second "+second);
    }
}
