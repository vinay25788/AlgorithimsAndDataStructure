package datastructure.array.pracitise.array.arrangement;

import java.util.HashMap;

public class LargestSubArrayWithEqual0sAnd1s {
    public static void main(String[] args) {
        int a[] = { 1, 0, 0, 1, 0, 1, 1 };
        findLargestSubArray(a);
    }
    public static void findLargestSubArray(int[] a)
    {
        int n = a.length;
        for(int i=0;i<n;i++)
           a[i] = a[i]==0? -1:1;

        HashMap<Integer,Integer> map = new HashMap<>();

        int sum =0,maxLength = Integer.MIN_VALUE,endingIndex = 0;
        for(int i=0;i<n;i++) {
            sum += a[i];
            if (sum == 0) {
                if (maxLength < i) {
                    maxLength = i + 1;

                    endingIndex = i;
                }

            }
            if (map.containsKey(sum)) {
                if (maxLength < i - map.get(sum)) {
                    maxLength = i - map.get(sum);
                    endingIndex = i;

                }
            } else
                map.put(sum, i);

        }

        int end = endingIndex - maxLength+1;
        System.out.println(end + " to "+endingIndex);
        System.out.println(maxLength);


        }
    }

