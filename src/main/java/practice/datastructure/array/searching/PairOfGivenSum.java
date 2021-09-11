package practice.datastructure.array.searching;

public class PairOfGivenSum {
    public static void main(String[] args) {
        int[] a ={3,4,2,6,8};
        int sum = 5;
        findPair(a,sum);
    }
    public static void findPair(int[] a,int sum)
    {
        int n = a.length;

        int i=0, j=1;
        while(i<n && j<n)
        {
            if(a[j]-a[i] == sum || a[i]- a[j] == sum)
            {
                System.out.println(a[i]+" "+a[j]);
                return;
            }
            else if (a[j]-a[i]>sum)
                i++;
            else
                j++;
        }

    }
}
