package datastructure.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertNewInterval {
    public static void main(String[] args) {
        int[][] intervals = new int[][]
                {
                        {1,2},{3,5},{6,7},{8,10},{12,16}

                };

        int[] newInterval = {4,8};

        int[][] test = insert(intervals,newInterval);

        for(int i=0;i<test.length;i++)
        {
            for(int j=0;j<test[i].length;j++)
            {
                System.out.print(test[i][j]+" ");
            }
            System.out.println();
        }
    }

   static public int[][] insert(int[][] intervals, int[] newInterval) {
        boolean inserted = false;
        if(intervals.length==0) return new int[][]{newInterval};
        List<int[]> output = new ArrayList<>();
        for(int idx=0; idx<intervals.length; idx++){
            if(!inserted && intervals[idx][1] >= newInterval[0] && intervals[idx][0] <= newInterval[1]){
                int mergeEnd = idx;
                while(mergeEnd+1<intervals.length && newInterval[1]>=intervals[mergeEnd+1][0]){
                    mergeEnd++;
                }
                mergeEnd = mergeEnd == intervals.length ? mergeEnd-1 : mergeEnd;
                output.add(new int[]{Math.min(intervals[idx][0], newInterval[0]), Math.max(newInterval[1], intervals[mergeEnd][1])});
                idx = mergeEnd;
                inserted = true;
            }else{
                output.add(intervals[idx]);
            }
        }
        if(!inserted) {
            for(int idx=0; idx<output.size(); idx++){
                if(output.get(idx)[0]>newInterval[0]){
                    output.add(idx, newInterval);
                    inserted = true;
                    break;
                }
            }
            if(!inserted)
                output.add(newInterval);
        }
        return output.stream().toArray(e-> new int[output.size()][2]);
    }


}
