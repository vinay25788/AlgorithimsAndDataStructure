package datastructure.array.order_statics;

public class FindFirstMissing {
    public static void main(String[] args) {
        //  int a[] = {0, 1, 2, 3, 4, 5, 6, 7, 10};
        int[] a = {5, 6, 7, 9, 10};
        int n = a.length;
        int first = a[0];
        System.out.println(findFirstMeeting(a, 0, a.length - 1, first));

    }

    public static int findFirstMeeting(int[] a, int start, int end, int first) {
        if (start < end) {
            int mid = (start + end) / 2;
            if (a[mid] == first + mid)
                return findFirstMeeting(a, mid + 1, end, first);
            else
                return findFirstMeeting(a, start, mid - 1, first);
        }
        return start + first;
    }
}
