package practice.datastructure.array.searching;

public class FindOddOccurance {
    public static void main(String[] args) {
       int a[] =  {2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2};
       findOddOccance(a);
    }
    public static void findOddOccance(int[] a)
    {
        int xor = a[0];
        for(int i=1;i<a.length;i++)
        {
            xor ^= a[i];
        }
        System.out.println(xor);
    }
}
