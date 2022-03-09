package datastructure.subset;

import java.util.ArrayList;
import java.util.List;

public class subset {
   static List<List<Integer>> list = new ArrayList<>();

   static public List<List<Integer>> subsets(int[] nums) {

        if(nums.length == 0)
            return list;
        solve(0,new ArrayList<>(),nums);
        return list;
    }


   static public void solve(int start,List<Integer> curList,int[] nums)
    {
        list.add(new ArrayList<>(curList));

        for(int i=start;i<nums.length;i++)
        {
            curList.add(nums[i]);

            solve(i+1,curList,nums);

            curList.remove(curList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        System.out.println(subsets(a));
    }
}
