package practice.datastructure.array.searching;

public class Duplicates {
    public static void main(String[] args) {
        int[] a = {1, 1,1,1,1,4,2,2,6};

        printDuplicates(a, a.length);
    }

    static void printDuplicates(int arr[], int n)
    {
        int i;

        // Flag variable used to
        // represent whether repeating
        // element is found or not.
        int fl = 0;

        for (i = 0; i < n; i++)
        {

            // Check if current element is
            // repeating or not. If it is
            // repeating then value will
            // be greater than or equal to n.
            if (arr[arr[i] % n] >= n)
            {

                // Check if it is first
                // repetition or not. If it is
                // first repetition then value
                // at index arr[i] is less than
                // 2*n. Print arr[i] if it is
                // first repetition.
                if (arr[arr[i] % n] < 2 * n)
                {
                    System.out.print( arr[i] % n + " ");
                    fl = 1;
                }
            }

            // Add n to index arr[i] to mark
            // presence of arr[i] or to
            // mark repetition of arr[i].
            arr[arr[i] % n] += n;
        }

        // If flag variable is not set
        // then no repeating element is
        // found. So print -1.
        if (!(fl > 0))
            System.out.println("-1");
    }
}
