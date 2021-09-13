package practice.String;

public class RobotPosition {
    public static void main(String[] args) {
        String st = "UDDLLRUUUDUURUDDUULLDRRRR";
        finalPosition(st);
    }
    private static void finalPosition(String st)
    {
        int n = st.length();
        int countUp =0,countDown =0,countLeft = 0,countRight =0;
        for(int i=0;i<n;i++)
        {
            if(st.charAt(i) == 'D')
                countDown++;
            else if (st.charAt(i) == 'U')
                countUp++;
            else if (st.charAt(i) == 'L')
                countLeft++;
            else if (st.charAt(i) == 'R')
                countRight++;
        }
        System.out.println((countRight-countLeft)+" , "+(countUp-countDown));
    }
}
