package practice.datastructure.array.order_static;

public class FindMinimumDistanceBetweenTwoNumber {
    public static void main(String[] args) {
        int[] a ={1,2,3,4,5,1};
        int x = 1;
        int y = 4;
        findDistance(a,x,y);
    }
    public static void findDistance(int[] a,int x,int y)
    {
        int minDis = Integer.MAX_VALUE;
        int n = a.length;
        int prev = -1;
        for(int i=0;i<n;i++)
        {
            if(a[i] == x || a[i] == y)
            {
                if(prev != -1 && a[prev]  != a[i] && minDis>i - prev)
                {
                    minDis = i - prev;
                    prev = i;
                }

                    prev = i;


            }

        }
        System.out.println(minDis);
    }
}
