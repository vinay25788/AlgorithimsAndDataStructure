package datastructure.array.searching_and_sorting;

public class FindMissingNumber {
    public static void main(String[] args) {
        int[] a ={ 1, 2, 4, 5, 6};
        findMissingNumber(a);

    }
    public static void findMissingNumber(int[] a)
    {
        int n = a.length;
        int first = a[0];
        int second = 1;

        for(int i=1;i<n;i++)
            first = first ^ a[i];

        for(int i=2;i<=n+1;i++)
            second = second ^ i;

        System.out.println(first ^ second);
    }
}
