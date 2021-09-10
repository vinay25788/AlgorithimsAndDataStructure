package practice.datastructure.array.searching;

public class MissingNumber {
    public static void main(String[] args) {
        int[] a={ 1, 2, 4, 5, 6 };
        missingNumber(a);
    }
    public static void missingNumber(int[] a)
    {
        int xor = a[0];
        int xor2 = 1;

        for(int i=1;i<a.length;i++)
            xor ^=a[i];
        for(int i=2;i<=a.length+1;i++)
            xor2 ^=i;
        System.out.println(xor ^xor2);

    }
}
