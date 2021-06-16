package datastructure.string;

public class SumOfDigitPresentInStrings {
    public static void main(String[] args) {
        String st ="12abc20yz68";
        calculateSum(st);
    }
    public static void calculateSum(String st)
    {
        String temp="0";
        int res=0;
        for(int i=0;i<st.length();i++)
        {
            char ch = st.charAt(i);
            if(Character.isDigit(ch))
                temp+=ch;
          else {
                res += Integer.parseInt(temp);
                temp = "0";
            }

        }
        System.out.println(res+Integer.parseInt(temp));
    }
}
