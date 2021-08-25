package datastructure.array.pracitise.array.orderstatics;

public class MaximumSumWithNoTwoAdjacent {
    public static void main(String[] args) {
        int arr[] = new int[]{5, 5, 10, 100, 10, 5};
        maximumSum(arr);
    }
    public static void maximumSum(int[] a)
    {
        int incl =0,excl =0,exclNew=0;
        for(int i=0;i<a.length;i++)
        {
            exclNew = (incl>excl ? incl:excl);
            incl = excl+a[i];
            excl = exclNew;
        }
        System.out.println(incl>excl? incl:excl);
    }
}
