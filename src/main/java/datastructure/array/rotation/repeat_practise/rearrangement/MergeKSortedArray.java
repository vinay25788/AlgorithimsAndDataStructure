package datastructure.array.rotation.repeat_practise.rearrangement;// Java program to merge k sorted arrays of size n each.
import java.util.*;

public class MergeKSortedArray{
    static final int n = 4;

    // Merge arr1[0..n1-1] and arr2[0..n2-1] into
// arr3[0..n1+n2-1]
    static void mergeArrays(int arr1[], int arr2[], int n1,
                            int n2, int arr3[])
    {
        int i = 0, j = 0, k = 0;

        // Traverse both array
        while (i<n1 && j <n2)
        {
            // Check if current element of first
            // array is smaller than current element
            // of second array. If yes, store first
            // array element and increment first array
            // index. Otherwise do same with second array
            if (arr1[i] < arr2[j])
                arr3[k++] = arr1[i++];
            else
                arr3[k++] = arr2[j++];
        }

        // Store remaining elements of first array
        while (i < n1)
            arr3[k++] = arr1[i++];

        // Store remaining elements of second array
        while (j < n2)
            arr3[k++] = arr2[j++];
    }

    // A utility function to print array elements
    static void printArray(int arr[], int size)
    {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i]+ " ");
    }

    // This function takes an array of arrays as an argument and
// All arrays are assumed to be sorted. It merges them together
// and prints the final sorted output.
    static void mergeKArrays(int arr[][], int i, int j, int output[])
    {
        // if one array is in range
        if(i == j)
        {
            for(int p = 0; p < n; p++)
                output[p] = arr[i][p];
            return;
        }

        //if only two arrays are left them merge them
        if(j - i == 1)
        {
            mergeArrays(arr[i], arr[j], n, n, output);
            return;
        }

        //output arrays
        int []out1 = new int[n*(((i + j) / 2) - i + 1)];
        int []out2 = new int[n*(j - ((i + j) / 2))];

        //divide the array into halves
        mergeKArrays(arr, i, (i + j) / 2, out1);
        mergeKArrays(arr, (i + j) / 2 + 1, j, out2);

        //merge the output array
        mergeArrays(out1, out2, n * (((i + j) / 2) - i + 1), n * (j - ((i + j) / 2)), output);
    }


    // Driver program to test above functions
    public static void main(String[] args)
    {

        // Change n at the top to change number of elements
        // in an array
        int arr[][] = {{2, 6, 12, 34},
                {1, 9, 20, 1000},
                {23, 34, 90, 2000}};
        int k = arr.length;
        int []output = new int[n*k];
        mergeKArrays(arr,0,2, output);

        System.out.print("Merged array is " +"\n");
        printArray(output, n*k);
    }
}

// This code is contributed by gauravrajput1
