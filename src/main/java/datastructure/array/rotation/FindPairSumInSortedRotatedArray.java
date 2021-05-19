package datastructure.array.rotation;

public class FindPairSumInSortedRotatedArray {

    public static void main(String[] args) {
        int[] a={11,15,5,6,9,10};
        int sum = 16;
        findPairSum(a,sum);
    }
    public static void findPairSum(int[] a,int sum)
    {
        int i;
        int n = a.length;
        for(i=0;i<a.length;i++)
            if(a[i]>a[i+1])
                break;
          int low = i+1;
          int high = i;
          i=0;
          while(low != high)
          {
              int current  = a[low] + a[high];
              if(current == sum)
              {
                  System.out.println(a[low]  + " + "+ a[high] +" = " +sum);
                  low = (low+1)%n;
                  high = (high-1+n)%n;
              }
              else if(current <=sum )
              {
                  low = (low+1+n)%n;

              }
              else
                  high = (high -1+n)%n;
          }
    }
}
