package LeetCode.图;

import LeetCode.Base.LeetCodeBase;

import java.util.ArrayList;
import java.util.List;

public class LC785 implements LeetCodeBase
{
    //二分图问题，染色
    int[] visited;
    int[] color;
    boolean ok=true;
    public boolean isBipartite(int[][] graph)
    {
        visited=new int[graph.length];
        color=new int[graph.length];
        for (int i=0;i<graph.length;i++)
        {
            if(graph[i].length!=0&&visited[i]==0)
            {
                color[i]=1;
                backTrack(graph,i);
            }
        }
        return ok;

    }

    public void backTrack(int[][] graph,int cur)
    {
        visited[cur]=1;
        for (int i:graph[cur])
        {
            if(visited[i]==0)
            {
                color[i]=color[cur]==1?2:1;
                backTrack(graph,i);
            }
            else
            {
                ok=color[cur]!=color[i];
                if(ok==false)
                {
                    return;
                }
            }
        }
    }

    @Override
    public void test()
    {
        System.out.println(isBipartite(new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}}));
//        System.out.println(isBipartite(new int[][]{{1,3},{0,2},{1,3},{0,2}}));

    }
}
