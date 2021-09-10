package practice.datastructure.array.order_static;

public class MaximumRepeatingElement {
    public static void main(String[] args) {
        int a[] = {1, 2, 2, 2, 2, 2,3,4,5,6,6,6,6,6,6,6,6,6,6,6};
        findMaxRepeatingEle(a);
    }

    public static void findMaxRepeatingEle(int[] a ){
        int n = a.length;
        for (int i = 0; i < n; i++)
            a[a[i] % n] += n;
        int max = a[0];
        int index = -1;
        for (int i = 1; i < n; i++) {
            if (max < a[i]) {
                max = a[i];
                index = i;
            }
        }

        for (int i = 0; i < n; i++)
            a[i] = a[i] % n;


        System.out.println(index);

    }
}
