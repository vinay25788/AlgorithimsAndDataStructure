package practice.String;

public class MinimumDeletionToMakePallindrome {
    public static void main(String[] args) {
        String st = "abefbac";
        System.out.println(minimumDeletion(st,0,st.length()-1));
    }
    private static int minimumDeletion(String st,int l,int h)
    {
        if(l>=h)
            return 0;
        if(st.charAt(l) == st.charAt(h))
            return minimumDeletion(st,l+1,h-1);
        else
            return 1+Math.min(minimumDeletion(st,l+1,h),minimumDeletion(st,l,h-1));
    }
}
