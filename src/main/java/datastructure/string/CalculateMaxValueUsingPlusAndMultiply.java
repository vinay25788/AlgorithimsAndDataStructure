package datastructure.string;


public class CalculateMaxValueUsingPlusAndMultiply {

    public static void main(String[] args) {
        String st = "01891";
        calculateSum(st);
    }
    public static void calculateSum(String st)
    {
        int result =0;
        for(int i=0;i<st.length();i++)
        {
            if(st.charAt(i) == '0'|| st.charAt(i) =='1' || result<2)
                result+=st.charAt(i)-'0';
            else
                result*=st.charAt(i)-'0';
        }
        System.out.println(result);
    }
}
