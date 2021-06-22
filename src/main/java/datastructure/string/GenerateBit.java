package datastructure.string;

// Java program to generate
// n-bit Gray codes
import java.io.*;
import java.util.*;
public class GenerateBit
{

    // This function generates all n
// bit Gray codes and prints the
// generated codes
    static ArrayList<String> generateGray(int n)
    {

        // Base case
        if (n <= 0)
        {
            ArrayList<String> temp =
                    new ArrayList<String>(){{add("0");}};
            return temp;
        }
        if(n == 1)
        {
            ArrayList<String> temp =
                    new ArrayList<String>(){{add("0");add("1");}};
            return temp;
        }

        // Recursive case
        ArrayList<String> recAns = generateGray(n - 1);
        ArrayList<String> mainAns = new ArrayList<String>();

        // Append 0 to the first half
        for(int i = 0; i < recAns.size(); i++)
        {
            String s = recAns.get(i);
            mainAns.add("0" + s);

        }

        // Append 1 to the second half
        for(int i = recAns.size() - 1; i >= 0; i--)
        {
            String s = recAns.get(i);
            mainAns.add("1" + s);
        }
        return mainAns;
    }

    // Function to generate the
// Gray code of N bits
    static void generateGrayarr(int n)
    {
        ArrayList<String> arr = new ArrayList<String>();
        arr = generateGray(n);

        // print contents of arr
        for (int i = 0 ; i < arr.size(); i++)
        {
            System.out.println(arr.get(i));
        }
    }

    // Driver Code
    public static void main (String[] args)
    {
        generateGrayarr(3);
    }
}

// This code is contributed by rag2127.
