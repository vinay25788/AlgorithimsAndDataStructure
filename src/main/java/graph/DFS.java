package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
     1 -> 2 ->3
          |     \5
          >
       -> 4
 */
public class DFS {

    List<Integer> adjacencyList[];
    int vertices;

    DFS(int v)
    {
        vertices =v;
        adjacencyList = new LinkedList[v+1];
        for(int i=0;i<v;i++)
        {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u,int v)
    {
        adjacencyList[u].add(v);
    }

    public void printGraph()
    {
        dfsUtil(1);
    }

    public void dfsUtil(int el)
    {
        Stack<Integer> st = new Stack<>();
        st.push(el);
        boolean visited[]= new boolean[vertices+1];


        visited[el]=true;

        while(!st.isEmpty())
        {
             el = st.pop();
            System.out.print(el+" ");
            Iterator<Integer> it = adjacencyList[el].iterator();
            while(it.hasNext())
            {
                int next=it.next();
                if(!visited[next])
                {
                    st.push(next);
                    visited[next] = true;
                }

            }

        }

    }

    public static void main(String[] args) {

        DFS dfs = new DFS(6);
        dfs.addEdge(1,2);
        dfs.addEdge(2,3);
        dfs.addEdge(2,4);
        dfs.addEdge(3,5);
        dfs.printGraph();



    }
}
