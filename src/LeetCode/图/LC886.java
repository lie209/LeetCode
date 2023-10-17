package LeetCode.图;

import LeetCode.Base.LeetCodeBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC886 implements LeetCodeBase
{
    int[] visited;
    int[] color;
    boolean ok=true;
    public boolean possibleBipartition(int n, int[][] dislikes)
    {
        visited=new int[n+1];
        color=new int[n+1];
        HashMap<Integer, List<Integer>> dislikeMap=new HashMap<>();
        for (int[] i:dislikes)
        {
            List<Integer> list=dislikeMap.getOrDefault(i[0],new ArrayList<>());
            list.add(i[1]);
            dislikeMap.put(i[0],list);
        }
        for (int[] i:dislikes)
        {
            List<Integer> list=dislikeMap.getOrDefault(i[1],new ArrayList<>());
            list.add(i[0]);
            dislikeMap.put(i[1],list);
        }
        for (int i=1;i<=n;i++)
        {
            if(visited[i]==0)
            {
                color[i]=1;
                backTrack(dislikeMap,i);
            }
        }
        return ok;
    }
    public void backTrack(HashMap<Integer,List<Integer>> map,int cur)
    {
        if(ok==false)
        {
            return;
        }
        visited[cur]=1;
        for (int i:map.getOrDefault(cur,new ArrayList<>()))
        {
            if(visited[i]==0)
            {
                color[i]=color[cur]==1?2:1;
                backTrack(map,i);
            }
            //如果已经染色了，则比较颜色
            else
            {
                ok=color[i]!=color[cur];
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
        System.out.println(possibleBipartition(4,new int[][]{{1,2},{1,3},{2,4}}));
        System.out.println(possibleBipartition(3,new int[][]{{1,2},{1,3},{2,3}}));
        System.out.println(possibleBipartition(4,new int[][]{{1,2},{3,4}}));
    }
}
