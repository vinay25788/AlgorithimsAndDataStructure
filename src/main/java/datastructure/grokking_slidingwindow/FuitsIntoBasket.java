package datastructure.grokking_slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class FuitsIntoBasket {
    static public int totalFruit(int[] fruits) {

        int i=0,j=0, n = fruits.length;
        Map<Integer,Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;

        while(j<n)
        {
            map.put(fruits[j], map.getOrDefault(fruits[j],0)+1);


            if(map.size()>2)
            {


                max = Math.max( max,(j-i));

                while(map.size()>2)
                {
                    max = Math.max( max,(j-i));
                    map.put(fruits[i],map.get(fruits[i])-1);
                    if(map.get(fruits[i]) ==0)
                        map.remove(fruits[i]);
                    i++;
                }

            }
            j++;
        }
        if( max == Integer.MIN_VALUE)
        {
            return (j-i);

        }
        return max;

    }

    public static void main(String[] args) {
       int[] a ={0,1,2,2};
        System.out.println(totalFruit(a));
    }
}
