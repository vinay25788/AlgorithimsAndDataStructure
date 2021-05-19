
package datastructure.array.searching_and_sorting;


// Java program to Find the repeating
// and missing elements

import java.io.*;

public class MissingAndRepeatingElement {
    static int x, y;

    static void getTwoElements(int arr[], int n)
    {
		/* Will hold xor of all elements
	and numbers from 1 to n */
        int xor1;

        /* Will have only single set bit of xor1 */
        int set_bit_no;

        int i;
        x = 0;
        y = 0;

        xor1 = arr[0];

        /* Get the xor of all array elements */
        for (i = 1; i < n; i++)
            xor1 = xor1 ^ arr[i];

		/* XOR the previous result with numbers from
	1 to n*/
        for (i = 1; i <= n; i++)
            xor1 = xor1 ^ i;

        /* Get the rightmost set bit in set_bit_no */
        set_bit_no = xor1 & ~(xor1 - 1);

		/* Now divide elements into two sets by comparing
	rightmost set bit of xor1 with the bit at the same
	position in each element. Also, get XORs of two
	sets. The two XORs are the output elements. The
	following two for loops serve the purpose */
        for (i = 0; i < n; i++) {
            if ((arr[i] & set_bit_no) != 0)
                /* arr[i] belongs to first set */
                x = x ^ arr[i];

            else
                /* arr[i] belongs to second set*/
                y = y ^ arr[i];
        }
        for (i = 1; i <= n; i++) {
            if ((i & set_bit_no) != 0)
                /* i belongs to first set */
                x = x ^ i;

            else
                /* i belongs to second set*/
                y = y ^ i;
        }

        /* *x and *y hold the desired output elements */
    }
    /* Driver program to test above function */
    public static void main(String[] args)
    {
        int arr[] = { 1, 3, 4, 5, 1, 6, 2 };

        int n = arr.length;
        getTwoElements(arr, n);
        System.out.println(" The missing element is "
                + x + "and the "
                + "repeating number is "
                + y);
    }
}

// This code is contributed by Gitanjali.

/*

public class MissingAndRepeatingElement {
    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5, 1, 6, 2};
        findMissingAndRepeating(a);
    }

    public static void findMissingAndRepeating(int[] a) {
        int n = a.length;

        int xor = a[0];
        for (int i = 1; i < n; i++)
            xor ^= a[i];
        for (int i = 1; i <= n; i++)
            xor ^= i;

        int setBitNumber = xor & ~(xor - 1);

        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            if ((setBitNumber & a[i]) != 0)
                x = x ^ a[i];
            else
                y = y ^ a[i];
        }
        for (int i = 1; i <= n; i++) {
            if ((setBitNumber & i) != 0) {
                x = x ^ i;
            } else
                y = y ^ i;
        }

        System.out.println("missing element is  " + x + " repeating element is  " + y);
    }
}
*/
