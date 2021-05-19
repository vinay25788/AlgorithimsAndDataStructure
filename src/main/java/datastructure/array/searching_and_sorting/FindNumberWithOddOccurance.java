package datastructure.array.searching_and_sorting;

public class FindNumberWithOddOccurance {
    public static void main(String[] args) {
        int[] a={1,2,3,4,1,2,3,4,3,3,1};
        findNumber(a);
    }
    public static void findNumber(int[] a)
    {
        int n= a.length;
        int result=0;
        for(int i=0;i<n;i++)
        {
            result = result^a[i];
        }
        System.out.println(result);
    }
}
