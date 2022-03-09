package datastructure.recursion;

import java.util.Arrays;
import java.util.List;

public class SortArrayUsingRecursion {
    public static void main(String[] args) {
        List<Integer> list=Arrays.asList(5,2,1,8);
        sort(list);
        System.out.println(list);
    }
    public static void sort(List<Integer> list)
    {
        if(list.size() ==0)
            return;
        int val = list.get(list.size()-1);
        list.remove(list.size()-1);
        sort(list);
        insert(list,val);
    }
    public static void insert(List<Integer> list,int val)
    {
        if(list.size() ==0 || list.get(list.size()-1)<=val)
            list.add( val);
        int temp = list.get(list.size()-1);
        list.remove(list.size()-1);
        insert(list,val);
        list.add(temp);
    }
}
