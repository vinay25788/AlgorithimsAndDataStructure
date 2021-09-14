package practice.String;

public class CheckIsAnotherStringSubsequence {
    public static void main(String[] args) {
        String str1 = "gksrek";
        String str2 = "geeksforgeeks";
        System.out.println(checkForSequence(str1,str2));
    }
    private static boolean checkForSequence(String s1, String s2)
    {
        int m = s1.length();
        int n = s2.length();

        int j=0;
        for(int i=0;i<n && j<m;i++)
            if(s1.charAt(j) == s2.charAt(i))
                j++;

            return j == m;

    }
}
