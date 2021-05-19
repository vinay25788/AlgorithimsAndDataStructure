package datastructure.array.searching_and_sorting;

public class FindPairWithGivenSum {
    public static void main(String[] args) {
        int[] a ={1, 8, 30, 40, 100};
        int x = 60;
        findPair(a,x);
    }
    public static void findPair(int[] a,int x)
    {
        int n = a.length;
        int i=0,j=1;
        while(i< n && j<n)
        {
            if(i!=j && i<n && a[j]-a[i] == x)
            {
                System.out.println(a[j] +" "+a[i]);
                return;
            }
            else if ( a[j] - a[i] < x)
                j++;
            else
                i++;
        }
    }
}
