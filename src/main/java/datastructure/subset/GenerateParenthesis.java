package datastructure.subset;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
   static public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        StringBuilder temp = new StringBuilder();

        solve(n,n,res,temp);
        return res;
    }

   static public void solve(int closeCount, int openCount, List<String> res,StringBuilder temp)
    {
        if(openCount == 0 && closeCount == 0)
        {
            res.add(temp.toString());
            return;
        }

        if(openCount>0)
        {
            temp.append("(");
            solve(closeCount, openCount-1,res,temp);
            temp.deleteCharAt(temp.length()-1);
        }
        if(closeCount>openCount)
        {
            temp.append(")");
            solve(closeCount-1,openCount,res,temp);
            temp.deleteCharAt(temp.length()-1);
        }
    }

    public static void main(String[] args) {
        int n =3;
        System.out.println(generateParenthesis(n));
    }
}
