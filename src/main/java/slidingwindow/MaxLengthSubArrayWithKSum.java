package slidingwindow;

public class MaxLengthSubArrayWithKSum {

    static    public int minSubArrayLen(int target, int[] a) {

        int i=0, j=0, curSum =0, minLength=Integer.MAX_VALUE;
        int n = a.length;

        while(j<=n) {
            /*if(curSum==target)
            {
                int length = j-i+1;
                if(minLength>length)
                    minLength = length;
                curSum -=a[i++];
              j++;
            }*/

            if( curSum<target)
            {
                curSum +=a[j];
                j++;
            }

        else    if( j==n || curSum==target)
            {
                int length = j-i+1;
                if(minLength>length)
                    minLength = length;
                if(j==n)
                    break;

                curSum -=a[i++];


            }
            else if ( curSum>target)
            {
                while(curSum>target & i<j)
                {
                    curSum -=a[i++];
                }
               // j++;
            }



        }
        return minLength;
    }

    public static void main(String[] args) {
        int target = 7, a[] ={2,3,1,2,4,3};
        System.out.println(minSubArrayLen(target,a));
    }
}
