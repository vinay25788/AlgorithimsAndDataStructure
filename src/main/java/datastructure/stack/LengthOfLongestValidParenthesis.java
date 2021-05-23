package datastructure.stack;

public class LengthOfLongestValidParenthesis {
    public static void main(String[] args) {
        System.out.print(solve("((()()()()(((())", 16));
    }
    public static int solve(String st,int n)
    {
        int left=0;
        int right=0;
        int maxLength =0;
        for(int i=0;i<n;i++)
        {
            if(st.charAt(i) == '(')
                left++;
            else
                right++;
            if(left == right)
            {
                maxLength = Math.max(maxLength,2*left);
            }
            if(left>right)
                left =right =0;
        }

        for(int i=n-1;i>=0;i--)
        {
            if(st.charAt(i)==')')
                right++;
            else
                left++;
            if(left == right)
                maxLength = Math.max(maxLength,2*right);
            if(right>left)
                left = right =0;

        }
        return maxLength;
    }
}
