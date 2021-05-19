package datastructure.array.searching_and_sorting;

public class MajorityOfArrayElement {
    public static void main(String[] args) {
        int[] a = {1, 3, 3,3,3, 1, 2};
        findMajority(a);
    }
    public static void findMajority(int[] a)
    {
        int cand = findCandidate(a);
        if(isMajority(cand,a))
            System.out.println(" Majority Element is "+cand);
        else
            System.out.println("no majority element");
    }
    public static boolean isMajority(int cand,int [] a)
    {
        int count =1;
        int n = a.length;
        for(int i=0;i<n;i++)
            if(a[i] == cand)
                count++;

        if(count >= n/2)
            return true;
        return false;
    }
    public static int findCandidate(int[] a)
    {
        int majIndex = 0;
        int n = a.length;
        int count =1;
        for(int i=1;i<n;i++)
        {
            if(a[majIndex] == a[i])
                count++;
            else
                count--;
            if(count == 0)
            {
                majIndex = i;
                count =1;
            }
        }
        return a[majIndex];
    }
}
