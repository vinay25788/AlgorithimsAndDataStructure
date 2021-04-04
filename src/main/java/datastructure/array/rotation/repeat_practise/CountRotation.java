package datastructure.array.rotation.repeat_practise;

public class CountRotation {
    public static void main(String[] args) {
        int[] a = new int[]{15, 18, 2, 3, 6, 12};
        System.out.println("number of ration " + countRotation(a, 0, a.length - 1));
    }

    public static int countRotation(int[] a, int l, int h) {
        if (h < l)
            return 0;
        int mid = (l + h) / 2;

        if (mid < h && a[mid + 1] < a[mid])
            return mid + 1;
        if (mid > l && a[mid] < a[mid - 1])
            return mid;
        if (a[mid] < a[h])
            return countRotation(a, l, mid - 1);
        return countRotation(a, mid + 1, h);
    }
}
