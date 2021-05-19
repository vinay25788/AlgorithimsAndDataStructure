package datastructure.array.searching_and_sorting;

public class FrequencyInSortedArray {
    public static void main(String[] args) {
        int[] a ={1, 2, 2, 2, 2,
                3, 4, 7, 8, 8};
        int x = 2;
        findFrequency(a,x);

    }
    public static void findFrequency(int[] a,int x)
    {
        int freq = findOccurance(a,x,0,a.length-1);
        if(freq == -1)
        {
            System.out.println(" didn't find the element");
            return;
        }
        int count=0;
        int n = a.length;
        for(int i=freq; i>=0 && a[i]== x;)
        {
            count++;
            i--;
        }
        for(int i = freq; i<n && a[i] == x;)
        {
            count++;
            i++;
        }
        System.out.println(" count of "+x+" is "+count);
    }

    public static int findOccurance(int[] a,int x,int l,int h)
    {
            if(h<l)
                return -1;

            int mid = l + (h-l)/2;
            if(a[mid] ==x)
                return mid;
            if(x<a[mid])
                return findOccurance(a,x,l,mid-1);

            return findOccurance(a,x,mid+1,h);

    }
}
