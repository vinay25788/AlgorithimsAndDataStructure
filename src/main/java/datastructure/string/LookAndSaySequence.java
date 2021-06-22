package datastructure.string;

public class LookAndSaySequence {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(generateNumber(n));
    }
    public static String generateNumber(int n)
    {
        if (n == 1)
        {
            return "1";
        }
        if(n ==2 )
        {
            return "11";
        }
        int count=1;
        String res = "11";

        for(int i=3;i<=n;i++)
        {
            res +="$";
            int len = res.length();
             count =1;
             char [] ar = res.toCharArray();
            String temp ="";

            for(int j=1;j<len;j++)
            {
                if(ar[j]!=ar[j-1])
                {
                    temp+=count+0;
                    temp+=ar[j-1];
                    count=1;
                }
                else
                    count++;
            }
            res = temp;
        }
        return res;
    }
}
