package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class ToysProblem {
    public static void main(String[] args) {
        String a = "abaccab";
        int k =2;
        System.out.println(findMaxLength(a,k));
    }

    public static int findMaxLength(String a,int k)
    {
        int i=0,j=0,maxLength = Integer.MIN_VALUE;
        int n = a.length();
        char []ch = a.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        while(j<n)
        {
            map.put(ch[j],map.getOrDefault(ch,0)+1);

            if(map.size() == k)
            {
                maxLength = Math.max(maxLength,j-i+1);
            }
            else if( map.size()>k)
            {
                while(map.size()>k)
                {
                    map.put(ch[i],map.get(ch[i])-1);
                    if(map.get(ch[i])==0)
                        map.remove(ch[i]);
                    i++;
                }
            }
            j++;
        }
        return maxLength;
    }
}
