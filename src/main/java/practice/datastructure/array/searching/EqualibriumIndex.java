package practice.datastructure.array.searching;

public class EqualibriumIndex {
    public static void main(String[] args) {
        int a[] = { -7, 1, 5, 2, -4, 3, 0 };
        findEqual(a);
    }
    public static void findEqual(int[] a)
    {
        int n = a.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = a[0];
        for(int i=1;i<n;i++)
            left[i] = left[i-1]+a[i];
        right[n-1] = a[n-1];

        for(int i=n-2;i>=0;i--)
            right[i]= right[i+1]+a[i];

        for(int i=0;i<n;i++)
            if(left[i] == right[i])
            {
                System.out.println(i);
                break;
            }

    }
}
