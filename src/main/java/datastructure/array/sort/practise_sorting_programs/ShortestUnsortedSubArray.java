package datastructure.array.sort.practise_sorting_programs;

public class ShortestUnsortedSubArray {
    public static void main(String[] args) {
        int[] a ={1,2,3,4,8,7,20};
        System.out.println(" length "+findShortestSubArray(a));
    }
    public static int findShortestSubArray(int[] a)
    {
        if(increasing (a,a.length) || decreasing(a, a.length))
            return 0;
        else
            return 3;

    }

    public static boolean increasing(int[] a,int n)
    {
        for(int i=0;i<n-1;i++)
        {
            if(a[i] >a[i+1])
                return false;
        }
        return true;
    }

    public static boolean decreasing(int[] a,int n)
    {
        for(int i=0;i<n-1;i++)
            if(a[i] < a[i+1])
                return false;
            return true;
    }
}
