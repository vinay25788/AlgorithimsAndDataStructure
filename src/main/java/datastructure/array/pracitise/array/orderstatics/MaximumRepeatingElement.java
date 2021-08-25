package datastructure.array.pracitise.array.orderstatics;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Test
{
    static int x=10;
    static int y = 2;
    private Test()
    {
        System.out.println( x*y);
    }
}
public class MaximumRepeatingElement {
    public static void main(String[] args) {
        int[] a ={2, 3, 3, 5, 3, 4, 1, 7};
        findMaximumRepeating(a);
        String s = "abc";
        Map<Integer,Integer> map = new HashMap<>();
        Set<Map.Entry<Integer,Integer>> set = map.entrySet();
        System.out.println('a'+0);
        //Character.isl
    }
    public static void findMaximumRepeating(int[] a)
    {

        int n = a.length;
        for(int i=0;i<n;i++)
        {
            a[a[i]%8]+=8;
        }
        int max = a[0];
        for(int i=0;i<n;++i)
            if(max <a[i])
                max = a[i];

        System.out.println(max%8);
    }
}

