package datastructure.array.searching_and_sorting;

public class FindUniqueElementUsingXor {
    public static void main(String[] args) {
        int[] a = {2, 3, 7, 9, 11, 2, 3, 11};
        findUnique(a);
    }
    public static void findUnique(int[] a)
    {
        int sum=0;
        for(int i=0;i<a.length;i++)
            sum ^= a[i];
        int sum1=0, sum2=0;
        for(int i=0;i<a.length;i++)
        {
            if((sum^a[i])>0)
                sum1 = sum1^a[i];
            else
                sum2 = sum2^a[i];
        }
    }
}
