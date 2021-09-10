package practice.datastructure.array.optimization;

public class MinimumNumberOfJumpToReachEnd {
    public static void main(String[] args) {
        int[] a = {1, 3, 8, 5, 9, 2, 6, 7, 6, 8, 9};
        calculateJump(a);
    }
    public static void calculateJump(int[] a)
    {

        int maxReach=a[0],steps = a[0],jumps =1;
        int n = a.length;

        for(int i=0;i<n;i++)
        {
            maxReach = Math.max(maxReach,a[i]);
            if(i== n-1)
            {
                System.out.println("jumps "+jumps);
                return;
            }
            steps--;
            if(steps == 0)
            {
                jumps++;
                if(i>=maxReach)
                {
                    System.out.println(" not possible ");
                    return;

                }
                steps = maxReach;
            }
        }

    }
}
