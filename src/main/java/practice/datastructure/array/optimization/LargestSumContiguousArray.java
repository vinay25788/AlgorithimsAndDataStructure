package practice.datastructure.array.optimization;

public class LargestSumContiguousArray {
    public static void main(String[] args) {
        int [] a = new int[] {-2, -3, 4, -1, -2, 1, 5, -3};
        largestSumSubArray(a);
    }
    public static void largestSumSubArray(int[] a)
    {
        int maxSoFar = 0;
        int maxEndingHere =0;

        int n = a.length;
        int start=0,ending =0;
        int s=0;
        for(int i=0;i<n;i++)
        {
            maxEndingHere +=a[i];
            if(maxEndingHere>maxSoFar)
            {
                maxSoFar = maxEndingHere;
                start = s;
                ending = i;
            }
            if(maxEndingHere<0)
            {
                maxEndingHere = 0;
                s = i+1;
            }
        }
        System.out.println(maxSoFar +" from starting "+start+" ending "+ending);
    }

}
