package datastructure_pattern.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class ContainDuplicate_LeetCode220 {

    static public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        Map<Integer,Integer> map = new HashMap<>();


        int i=0,j=0;
        int n = nums.length;
        while(j<n)
        {
            if(i!=j && Math.abs(nums[j]-nums[i])<= t && Math.abs(i-j)<=k)
            {
                return true;
            }
            if (Math.abs(i-j)>=k)
            {
                i++;
            }
            j++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a ={1,2,2,3,4,5};
        int k =3;
        int t = 0;
        System.out.println(containsNearbyAlmostDuplicate(a,k,t));
    }
    }

