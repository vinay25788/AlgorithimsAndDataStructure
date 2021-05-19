package datastructure.array.searching_and_sorting;

public class FindPairOfGivenSum {
    public static void main(String[] args) {
        int[] a ={10, 22, 28, 29, 30, 40};
        int x = 54;
        findPair(a,x);
    }
    public static void findPair(int[] a,int x)
    {
        int i=0;
        int l= 0, r = a.length-1;
        int diff = Integer.MAX_VALUE;
        int leftInd =-1,rightIndex=-1;
        while(l<r)
        {

            if(Math.abs((a[l]+a[r])-x) <diff)
            {
                System.out.println(a[l]+" "+a[r]);
                diff = x-(a[l]+a[r]);
                leftInd = l;
                rightIndex = rightIndex;

            }
            else if ( a[l]+a[r]>x)
                r--;
            else
                l++;
        }
    }
}
