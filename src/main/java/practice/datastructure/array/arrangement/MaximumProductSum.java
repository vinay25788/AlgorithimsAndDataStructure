package practice.datastructure.array.arrangement;

public class MaximumProductSum {
    public static void main(String[] args) {
       int a[] = {6, -3, -10, 0, 2};
       findMaxSum(a);
    }
    public static void findMaxSum(int[] a)
    {
        int maxEndingHere = 1,minEndingHere =1;
        int max =0;
        int n = a.length;
        int flag =0;
        for(int i=0;i<n;i++)
        {
            if(a[i]>0)
            {
                maxEndingHere = maxEndingHere*a[i];
                minEndingHere = Math.max(minEndingHere* a[i],1);
                flag =1;
            }
            else if ( a[i] == 0)
            {
                maxEndingHere = 1;
                minEndingHere = 1;
            }
            else
            {
                int temp = maxEndingHere;
                maxEndingHere = Math.max(minEndingHere*a[i],1);
                minEndingHere = temp * a[i];
            }

            if(max< maxEndingHere)
                max = maxEndingHere;
        }
        System.out.println(max);
    }
}
