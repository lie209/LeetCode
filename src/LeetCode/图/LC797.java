package LeetCode.图;

import LeetCode.Base.LeetCodeBase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC797 implements LeetCodeBase
{
    List<List<Integer>> result=new ArrayList<>();
    int[] visited;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph)
    {
        visited=new int[graph.length];
        List<Integer> list=new ArrayList<>();
        list.add(0);
        backTrack(graph,list,0);
        return result;
    }


    public void backTrack(int[][] graph,List<Integer> list,int cur)
    {

        if(!list.isEmpty()&&list.get(list.size()-1)==graph.length-1)
        {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i:graph[cur])
        {
            if(visited[i]==0)
            {
                visited[i]=1;
                list.add(i);
                backTrack(graph,list,i);
                list.remove(list.size()-1);
                visited[i]=0;
            }
        }
    }
    @Override
    public void test()
    {
//        System.out.println(allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}}));
        System.out.println(allPathsSourceTarget(new int[][]{{4,3,1},{3,2,4},{3},{4},{}}));

    }
}
