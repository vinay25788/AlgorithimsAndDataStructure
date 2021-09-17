package practice.String;

public class MaximumValueUsingPlusMultiply {
    public static void main(String[] args) {
        String st = "01891";
        System.out.println(getMaxValue(st));
    }
    private static int getMaxValue(String st)
    {
        int res = st.charAt(0) - '0';

        for(int i=1;i<st.length();i++)
        {
            if(st.charAt(i) == '0' || st.charAt(i) == '1' || res <2)
                res += st.charAt(i) -'0';
            else
                res *= st.charAt(i) -'0';
        }
        return res;
    }
}
