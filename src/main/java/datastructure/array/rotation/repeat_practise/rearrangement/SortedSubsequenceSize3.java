package datastructure.array.rotation.repeat_practise.rearrangement;

public class SortedSubsequenceSize3 {
    public static void main(String[] args) {

        int[] a = {1, 2, -1, 7, 5};
        subSequenceWithNewArray(a);
        subSequenceWithoutArray(a);
    }

    public static void subSequenceWithoutArray(int[] a) {
        int min = a[0];
        int max = Integer.MIN_VALUE;
        int n = a.length;
        int subSequence = 1;
        int storeMinimum = min;
        for(int i=0;i<n;i++)
        {
            if(a[i] == min)
                continue;
          else  if(a[i] < min)
            {
                min = a[i];
                continue;
            }
          else if ( a[i] < max)
            {
                max = a[i];
                storeMinimum = min;
            }
          else if ( a[i] > max)
            {
                subSequence++;
                if( subSequence == 3)
                {
                    System.out.println(storeMinimum+" "+max+ " "+a[i]);
                    return;
                }
                max= a[i];
            }
        }
    }

    public static void subSequenceWithNewArray(int[] a) {
        int min = 0, n = a.length;
        int[] smaller = new int[n];
        smaller[0] = -1;
        for (int i = 1; i < n; i++) {
            if (a[i] <= a[min]) {
                min = i;
                smaller[i] = -1;
            } else
                smaller[i] = min;
        }

        int[] greater = new int[n];
        int max = n - 1;
        greater[max] = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] >= a[max]) {
                max = i;
                greater[i] = -1;
            } else
                greater[i] = max;

        }

        for (int i = 0; i < n; i++) {
            if (smaller[i] != -1 && greater[i] != -1)
                System.out.println("triplet is " + a[smaller[i]] + " " + a[i] + " " + a[greater[i]]);
        }

    }
}
