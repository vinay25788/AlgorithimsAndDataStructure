package datastructure.string;
public class FindNumberOfTImeStringOccur {
    public static void main(String[] args) {
        String s1 = "GeeksforGeeks";
        String s2  = "Gks";
        System.out.println(findOccurance(s1,s2,s1.length(),s2.length()));

    }
    public static int findOccurance(String s1,String s2,int m,int n)
    {
        if((m==0 && n==0) || n==0)
            return 1;
        if(m==0)
            return 0;
        if(s1.charAt(m-1)==s2.charAt(n-1))
            return findOccurance(s1,s2,m-1,n-1)+findOccurance(s1,s2,m-1,n);
       else
        return findOccurance(s1,s2,m-1,n);
    }
}
