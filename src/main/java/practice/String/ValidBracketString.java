package practice.String;

public class ValidBracketString {
    public static void main(String[] args) {
        String st = "((()()()()(((())";
        checkForValide(st);
    }
    public static void checkForValide(String st)
    {
        int left =0,right =0, maxLength = Integer.MIN_VALUE;
        int n = st.length();

        for(int i=0;i<n;i++)
        {
            if(st.charAt(i) == '(')
                left++;
            else
                right++;
            if(left == right)
                maxLength = Math.max(maxLength,right*2);
            else if (right>left)
                left = right = 0;

        }
        left = right = 0;

        for(int i=n-1;i>0;i--)
        {
            if(st.charAt(i)== '(')
                left++;
            else
                right++;
            if(left == right)
                maxLength = Math.max(maxLength,left*2);
            if(left>right)
                left = right =0;
        }
        System.out.println(maxLength);
    }
}
