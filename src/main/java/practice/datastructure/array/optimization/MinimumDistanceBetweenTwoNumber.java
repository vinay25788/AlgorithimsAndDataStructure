package practice.datastructure.array.optimization;

public class MinimumDistanceBetweenTwoNumber {
    public static void main(String[] args) {
       int[] a= { 3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3 };
       findDistance(a,3,6);
    }
    public static void findDistance(int[] a,int x,int y)
    {
        int minDist = Integer.MAX_VALUE;
        int prev =-1;

        int n = a.length;
        for(int i=0;i<n;i++)
        {
            if(a[i] == x || a[i] == y)
            {
                if(prev !=-1 && a[i] != a[prev])
                    minDist = Math.min(minDist,i-prev);
                prev = i;
            }
        }
        System.out.println(minDist);

    }
}
