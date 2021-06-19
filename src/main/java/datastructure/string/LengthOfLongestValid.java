package datastructure.string;

import java.util.Stack;

public class LengthOfLongestValid {
    public static void main(String[] args) {
        String st = "(((())))";
        System.out.println(findLength(st));
        System.out.println(findLengthUsingStack(st));
    }

    public static int findLengthUsingStack(String st)
    {
        int result =0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<st.length();i++)
        {
            if(st.charAt(i)=='(')
                stack.push(i);
            else
            {
                if(!stack.isEmpty())
                    stack.pop();
                if(!stack.isEmpty())
                    result = Math.max(result,i-stack.peek());
                else
                    stack.push(i);
            }
        }
        return result;
    }

    public static int findLength(String st) {
        int left = 0, right = 0, maxLength = Integer.MIN_VALUE;
        int n = st.length();
        for (int i = 0; i < n; i++) {
            if (st.charAt(i) == '(')
                left++;
            else
                right++;
            if (left == right)
                maxLength = Math.max(maxLength, 2 * right);
            else if (right > left)
                left = right = 0;
        }
        left = right =0;

        for(int i=n-1;i>=0;i--)
        {
            if(st.charAt(i) == '(')
                left++;
            else
                right++;
            if(left == right)
                maxLength = Math.max(maxLength,2*left);
            else if(left>right)
                left=right=0;
        }
        return maxLength;


    }
}
