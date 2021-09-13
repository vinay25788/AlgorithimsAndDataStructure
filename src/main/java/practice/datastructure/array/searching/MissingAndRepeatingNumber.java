package practice.datastructure.array.searching;

import java.util.HashMap;
import java.util.Map;

public class MissingAndRepeatingNumber {
    public static void main(String[] args) {
        int a[] = {7, 3, 4, 5, 5, 6, 2};
        findMissingAndRepeating(a);
        int b[] = {4, 3, 6, 2, 1, 1};
        missingUsingHashMap(b);
        int c[] = {1, 3, 4, 5, 1, 6, 2};
        usingXor(c);
    }

    public static void usingXor(int[] arr) {

        int xor1;
        int n = arr.length;

        /* Will have only single set bit of xor1 */
        int set_bit_no;

        int i;
        int x = 0;
        int y = 0;

        xor1 = arr[0];

        /* Get the xor of all array elements  */
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
        System.out.println(" missing "+x+" repeating "+y);

        /* *x and *y hold the desired output elements */
        /*int n = a.length;
        int xor = a[0];
        for (int i = 1; i < n; i++)
            xor ^= a[i];

        for (int i = 1; i <= n; i++)
            xor ^= i;

        int setBit = xor & ~(xor - 1);

        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            if ((a[i] & setBit) > 0)
                x = x ^ a[i];
            else
                y ^= a[i];
        }
        for (int i = 1; i <= n; i++) {
            if ((i & setBit) > 0)
                x = x ^ i;
            else
                y ^= i;
        }
        System.out.println("missing " + x + " Repeating " + y);*/
    }

    public static void findMissingAndRepeating(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int val = Math.abs(a[i]);

            if (a[val - 1] > 0)
                a[val - 1] = -a[val - 1];
            else {
                System.out.println("repeating " + val);
            }
        }

        for (int i = 0; i < n; i++)
            if (a[i] > 0)
                System.out.println(i + 1);
    }

    public static void missingUsingHashMap(int[] a) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int el : a) {
            if (map.get(el) == null)
                map.put(el, true);
            else {
                System.out.println("repeating  using map " + el);
                break;
            }
        }
        for (int i = 1; i <= a.length; i++) {
            if (map.get(i) == null) {
                System.out.println("missing " + i);
                break;
            }
        }
    }
}
