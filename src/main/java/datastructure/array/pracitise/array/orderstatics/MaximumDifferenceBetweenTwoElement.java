package datastructure.array.pracitise.array.orderstatics;

public class MaximumDifferenceBetweenTwoElement {
    public static void main(String[] args) {
        int arr[] = new int[]{80, 2, 6, 3, 100};
        findMaximumDiff(arr);
    }
    public static void findMaximumDiff(int[] a)
    {
        int miniNumber = a[0];
        int maxDiff = a[1]-a[0];

        for(int i=1;i<a.length;i++)
        {
            if(a[i]<miniNumber)
                miniNumber = a[i];
            else
            {
                int curDiff = a[i]-miniNumber;
                if(curDiff>maxDiff)
                    maxDiff = curDiff;
            }
        }
        System.out.println(maxDiff);
    }
}
