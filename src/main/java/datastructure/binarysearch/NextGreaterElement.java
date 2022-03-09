package datastructure.binarysearch;

public class NextGreaterElement {

    static public char nextGreatestLetter(char[] a, char target) {

        int start =0;
        int end = a.length -1;
        char res = ' ';
        int n = a.length;
        while(start<=end)
        {
            int mid = (start + (end - start)/2);

            if(a[mid] == target)
            {
                start = (mid+1+n)%n;
            }
            else if(a[mid]<target)
            {
                start = mid+1;
            }
            else
            {
                res = a[mid];
                end = mid-1;
            }
        }

        return res;

    }

    public static void main(String[] args) {
        char[] ch = {'c','f','j'};
        char target = 'j';
        System.out.println(nextGreatestLetter(ch,target));
    }
}
