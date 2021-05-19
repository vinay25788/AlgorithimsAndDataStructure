package datastructure.array.rotation.practise;

public class FindMaximumSumWithIndexMultiplicationRoation {
    public static void main(String[] args) {

        // i*a[i]
        int[] a={3,4,5,6,1,2};
        System.out.println(findSumWithIndexRotation(a));
    }
    public static int findSumWithIndexRotation(int[] a)
    {
        int sum=0;
        int curVal =0, maxVal = 0,i=0;
        for(int el:a)
        {
            sum+=el;
            curVal += i*el;
            i++;
        }
        maxVal = curVal;
        int n = a.length;
        for(int j=1;j<n;j++)
        {
            curVal = curVal+sum - n*a[n-j];
            if(maxVal<curVal)
                maxVal = curVal;
        }
        return maxVal;
    }

}
