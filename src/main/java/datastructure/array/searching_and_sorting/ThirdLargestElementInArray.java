package datastructure.array.searching_and_sorting;

public class ThirdLargestElementInArray {
    public static void main(String[] args) {
        int[] a={19, -10, 20, 14, 2, 16, 10};
        findThirdLargest(a);
    }
    public static void findThirdLargest(int[] a)
    {
        int first=0,second =0,third=0;
        int n = a.length;
        for(int i=0;i<n;i++)
        {
            if(first<a[i])
            {
                third =second;
                second = first;
                first = a[i];
            }
            else if ( second < a[i])
            {
                third = second;
                second = a[i];
            }
            else if ( third < a[i]){
                third = a[i];
            }

        }
        System.out.println("third largest "+third);
    }
}
