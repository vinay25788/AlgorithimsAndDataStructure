package datastructure.array.arragement_rearrangement;

public class FindSortedSubsequenceOfSize3 {
    public static void main(String[] args) {
        int[] a=  { 12, 11, 10, 5, 6, 2, 30 };
        findSequence(a);
    }
    public static void findSequence(int[] a)
    {
        int n = a.length;
        int max = n-1;
        int min =0;
        int[] smaller = new int[n];
        smaller[0] =-1;
        for(int i=0;i<n;i++)
        {
            if(a[i]<=a[min])
            {
                min = i;
                smaller[i] = -1;
            }
            else
                smaller[i] =min;
        }
        int[] greater = new int[n];
        greater[max] =-1;
        for(int i=n-2;i>=0;i--)
        {
            if(a[i] >= a[max])
            {
                max = i;
                greater[i] = -1;
            }
            else
                greater[i] = max;
        }

        for(int i=0;i<n;i++)
        {
            if(smaller[i] != -1 && greater[i] != -1)
            {
                System.out.println(a[smaller[i]]+ " "+ a[i] +" "+a[greater[i]]);
                return;
            }
        }
    }
}
