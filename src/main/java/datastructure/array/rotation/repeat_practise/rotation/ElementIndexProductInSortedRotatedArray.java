package datastructure.array.rotation.repeat_practise.rotation;

/*
Find maximum value of Sum( i*arr[i]) with only rotations on given array allowed
 */
public class ElementIndexProductInSortedRotatedArray {
    public static void main(String[] args) {
        int[] a = new int[]{1, 20, 2, 10};
        System.out.println("maximum sum for i*a[i]  " + findSum(a));
    }

    public static int findSum(int[] a) {
        int sum = 0, curVal = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            curVal += i * a[i];
        }
        System.out.println(" sum -->" + sum + "  curVal   " + curVal);
        int maxVal = curVal;
        for (int i = 1; i < n; i++) {
            curVal = curVal + sum - n * a[n - i];
            if (curVal > maxVal)
                maxVal = curVal;
        }

        return maxVal;

    }

}
