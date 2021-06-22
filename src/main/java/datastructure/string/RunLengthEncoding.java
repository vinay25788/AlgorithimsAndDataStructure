package datastructure.string;

public class RunLengthEncoding {
    public static void main(String[] args) {
        String st = "wwwwaaadexxxxxxywww";
        printLengthEncoding(st);
    }
    public static void printLengthEncoding(String st)
    {
        int count =1;
        int n = st.length();
        for(int i=0;i<n;i++)
        {
            while(i<n-1 && st.charAt(i) == st.charAt(i+1))
            {
                count++;i++;
            }
            System.out.print(st.charAt(i));
            System.out.print(count);
            count =1;
        }
    }
}
