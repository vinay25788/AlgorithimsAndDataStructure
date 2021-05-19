package datastructure.array.rotation.practise;

public class MaximumSumforRotationFactor {
    public static void main(String[] args) {
        int[] a={3,4,5,6,1,2};
        System.out.println(findSum(a));
    }
    public static int findSum(int[] a)
    {
        int curVal=0,sum = 0,maxVal=0;
        for(int i=0;i<a.length;i++)
        {
            sum+= a[i];
            curVal+= i*a[i];
        }
        maxVal = curVal;
        int n = a.length;
        for(int j=1;j<n;j++)
        {
            int nextVal = curVal - (sum - a[j-1]) + a[j-1]*(n-j);
            curVal = curVal+sum- n*a[n-j];
            if(curVal>maxVal)
                maxVal = curVal;
        }
        return maxVal;

    }
}
