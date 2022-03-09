package datastructure.twopointer;

public class LengthOfShortestSubArray {
    static  public int findLengthOfShortestSubarray(int[] arr) {


        int low = 0;
        int high = arr.length - 1;

        while (low < arr.length - 1 && arr[low] <= arr[low + 1])
            low++;

        if (low == arr.length - 1)
            return 0;

        while (low < high && arr[high] >= arr[high - 1]) {
            high--;
        }

        int result = Math.min(high, arr.length - low - 1);

        int i = 0;
        int j = high;

        while (i <= low && j < arr.length) {
            if (arr[j] >= arr[i]) {
                result = Math.min(j - i - 1, result);
                i += 1;
            } else
                j += 1;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a ={1,2,3,10,4,2,3,5};
        System.out.println(findLengthOfShortestSubarray(a));
    }
}
