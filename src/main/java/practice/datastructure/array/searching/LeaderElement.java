package practice.datastructure.array.searching;

public class LeaderElement {
    public static void main(String[] args) {
        int[] a={16, 17, 4, 3, 5, 2};
        findLeader(a);
    }
    public static void findLeader(int[] a)
    {
        int n = a.length;
        int max=a[n-1];
        System.out.print(max+" ");
        for(int i=n-2;i>=0;i--)
        {
            if(max < a[i])
            {
                max = a[i];
                System.out.print(max+" ");

            }
        }
    }
}
