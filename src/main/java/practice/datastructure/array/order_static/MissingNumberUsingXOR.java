package practice.datastructure.array.order_static;

public class MissingNumberUsingXOR {
    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5, 6};
        missingNumber(a);
    }

    public static void missingNumber(int[] a) {
        int n = a.length;
        int x1 = 1;
        for (int i = 2; i <= n+1; i++) {
            x1 = x1^i;
        }
        int x2 = a[0];
        for(int i=1;i<n;i++)
            x2 = x2^a[i];
        System.out.println(x1^x2);
    }
}
