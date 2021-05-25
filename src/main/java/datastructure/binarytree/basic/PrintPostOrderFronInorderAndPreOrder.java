package datastructure.binarytree.basic;

import java.util.HashMap;
import java.util.Map;

public class PrintPostOrderFronInorderAndPreOrder {
    static int preIndex =0;
    public static void main(String[] args) {
        int in[] = { 4, 2, 5, 1, 3, 6 };
        int pre[] = { 1, 2, 4, 5, 3, 6 };

        printPostOrder(in,pre);
    }
    public static void printPostOrder(int[] in,int[] pre)
    {
        Map<Integer,Integer> map = new HashMap<>();
        int preLength = pre.length;
        int inLength = in.length;
        for(int i=0;i<preLength;i++)
            map.put(in[i],i);
        printPost(in,pre,0,preLength-1,map);
    }

    public static void printPost(int[] in,int[] pre,int inStart,int inEnd,Map<Integer,Integer> map)
    {
        if(inStart>inEnd)
            return;
        int inIndex = map.get(pre[preIndex++]);
        printPost(in,pre,inStart,inIndex-1,map);
        printPost(in,pre,inIndex+1,inEnd,map);
        System.out.print(" "+in[inIndex]);

    }

}
