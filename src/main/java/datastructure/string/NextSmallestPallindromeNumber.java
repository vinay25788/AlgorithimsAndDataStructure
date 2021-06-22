package datastructure.string;

import java.util.Arrays;

public class NextSmallestPallindromeNumber {
    public static void main(String[] args) {
        int num[] = {9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2};
        generateNextNumber(num);
    }

    public static void generateNextNumber(int[] num) {
        if (num.length == 0)
            return;
        if (allDigit9(num)) {
            System.out.print("1");
            for (int i = 0; i < num.length; i++)
                System.out.print(num[i]);
            System.out.print("1");
            return;
        }
        numberUtil(num);
    }

    public static boolean allDigit9(int[] num) {
        for (int i = 0; i < num.length; i++)
            if (num[i] != 9)
                return false;
        return true;
    }

    public static void numberUtil(int[] num) {
        int n = num.length;
        int mid = n / 2;
        int i = mid - 1;
        int j = (n % 2 == 0 ? mid : mid + 1);
        while (i >= 0 && num[i] == num[j]) {
            i--;
            j++;
        }
        boolean smaller = false;
        if (i < 0 || num[i] < num[j])
            smaller = true;
        while (i >= 0) {
            num[j++] = num[i--];
        }
        if (smaller) {
            int carry = 1;
            if (n % 2 == 1) {
                num[mid] += 1;
                carry = num[mid] / 10;
                num[mid] %= 10;
            }
            i = mid - 1;
            j = (n % 2 == 0 ? mid : mid + 1);
            while (i >= 0 && carry > 0) {
                num[i] += carry;
                carry = num[i] / 10;
                num[i] %= 10;
                num[j] = num[i];
                i--;
                j++;
            }
        }
        for( i=0;i<n;i++)
            System.out.print(num[i]);

    }
}
