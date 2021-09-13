package practice.String;

public class PrintXTypeString {
    public static void main(String[] args) {
        String st = "geeksforgeeks";
        print(st);

    }
    private static void print(String st)
    {
        int n = st.length();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==j || i+j == n-1)
                    System.out.print(st.charAt(j));
                else
                    System.out.print(" ");

            }
            System.out.println();
        }
    }
}
