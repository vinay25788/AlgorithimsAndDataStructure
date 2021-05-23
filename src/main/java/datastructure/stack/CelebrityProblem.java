package datastructure.stack;

import java.util.Stack;

public class CelebrityProblem {

  static  int[][] mat = { { 0, 0, 1, 0 },
            { 0, 0, 1, 0 },
            { 0, 0, 0, 0 },
            { 0, 0, 1, 0 } };

    public static Boolean knows(int[][] mat,int a,int b)
    {
        return mat[a][b] == 1 ? true :false;
    }

    public static int findCelebrity(int[][] mat)
    {
        Stack<Integer> st = new Stack<>();
        int n = mat.length;
        for(int i=0;i<n;i++){
            st.push(i);
        }

        while(st.size()>1)
        {
            int a = st.pop();
            int b = st.pop();
            if(knows(mat,a,b) == true)
            {
                st.push(b);
            }
            else
                st.push(a);

        }

        if(st.isEmpty())
            return -1;
        int c = st.pop();

        for(int i=0;i<n;i++)
        {
            if(i!=c && ((knows(mat,c,i) || !knows(mat,i,c))))
            {
                return -1;
            }

        }
        return c;

    }

    public static void main(String[] args) {


        System.out.println(findCelebrity(mat));
    }
}
