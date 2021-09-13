package practice.datastructure.array.searching;

public class TwoUniqueElement {
    public static void main(String[] args) {
        int[] a ={ 1,2,3,4,2,3,4,5};
        findUnique(a);
        UniqueNumbers2 (a,a.length);
    }
    public static void UniqueNumbers2(int[] arr, int n)
    {
        int sum = 0;
        for (int i = 0; i < n; i++) {

            // Xor  all the elements of the array
            // all the elements occuring twice will
            // cancel out each other remaining
            // two unnique numbers will be xored
            sum = (sum ^ arr[i]);
        }

        // Bitwise & the sum with it's 2's Complement
        // Bitwise & will give us the sum containing
        // only the rightmost set bit
        sum = (sum & -sum);

        // sum1 and sum2 will contains 2 unique
        // elements elements initialized with 0 box
        // number xored with 0 is number itself
        int sum1 = 0;
        int sum2 = 0;

        // traversing the array again
        for (int i = 0; i < arr.length; i++) {

            // Bitwise & the arr[i] with the sum
            // Two possibilities either result == 0
            // or result > 0
            if ((arr[i] & sum) > 0) {

                // if result > 0 then arr[i] xored
                // with the sum1
                sum1 = (sum1 ^ arr[i]);
            }
            else {
                // if result == 0 then arr[i]
                // xored with sum2
                sum2 = (sum2 ^ arr[i]);
            }
        }

        // print the the two unique numbers
        System.out.println("The non-repeating elements are "
                + sum1 + " and " + sum2);
    }
    public static void findUnique(int[] a)
    {
        int sum =0,n = a.length;
        for(int i=0;i<n;i++)
            sum ^=a[i];

        sum = (sum & -sum);

        int x =0,y=0;
        for(int i=0;i<n;i++)
        {
            if((sum & a[i])>0)
                x ^=a[i];
            else
                y ^=a[i];
        }
        System.out.println(x +" "+y);
    }
}
