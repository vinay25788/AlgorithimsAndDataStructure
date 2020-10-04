package datastructure.array.order_statics;

import java.util.Arrays;

public class KthSmallestElementInArraySimpleSolution {

    public static void main(String[] args) {

        int[] a={4,2,6,1,5};
        int k=2;
        Arrays.sort(a);
        System.out.println(a[k-1]);

    }

}
