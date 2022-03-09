package dynamicprogramming.mcm;

public class EvaluateExpressionCountWays {
    public static int parseBoolExpr(String expression) {

        return solve(expression.toCharArray(),0,expression.length()-1,true);

    }

   static int solve (char[] exp,int i,int j,boolean isTrue)
    {
        if(i>j)
            return 0;
        if(i==j)
        {
            if(isTrue)
                return exp[i]=='t' ? 1:0;
            else
                return exp[i] == 'f' ? 1:0;
        }

        int ans = 0;

        for(int k=i+1;k<j;k+=2)
        {
            int lt = solve(exp,i,k-1,true);
            int lf = solve(exp,i,k-1,false);
            int rt = solve(exp,k+1,j,true);
            int rf = solve(exp, k+1,j,false);

            if(exp[k] == '&')
            {
                if(isTrue)
                    ans+= lt*rt;
                else
                    ans+= lf*rt + rf*lt + lf*rf;
            }
            else if(exp[k] == '|')
            {
                if(isTrue)
                    ans+= lt*rf + rt*lf + lt*rt;
                else
                    ans+= lf*rf;
            }
            else if(exp[k] == '^')
            {
                if(isTrue)
                    ans+= lf * rt + lt * rf;
                else
                    ans+= lf*rf + lt*rt ;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "t|t&f^t";
        System.out.println(parseBoolExpr(s));
    }
}