package LeetCode.图;

import LeetCode.Base.LeetCodeBase;

import java.util.*;

public class LC210 implements LeetCodeBase
{
    int[] visited;
    Boolean ok=true;
    List<Integer>[] lists;
    Stack<Integer> stack=new Stack<>();
    HashSet<Integer> set=new HashSet<>();
    public int[] findOrder(int numCourses, int[][] prerequisites)
    {
        visited=new int[numCourses];
        lists=new ArrayList[numCourses];
        for (int i=0;i<numCourses;i++)
        {
            lists[i]=new ArrayList<>();
        }
        if(prerequisites.length==0)
        {
            int[] result=new int[numCourses];
            for (int i=0;i<numCourses;i++)
            {
                result[i]=i;
            }
            return result;
        }
        for (int i=0;i<prerequisites.length;i++)
        {
            lists[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for (int i=0;i<lists.length;i++)
        {
            if(lists[i].size()>0)
            {
                backTrack(prerequisites,i);
            }
        }
        if(ok==false)
        {
            return new int[]{};
        }
        else
        {
            for (int i=0;i<numCourses;i++)
            {
                if(!set.contains(i))
                {
                    stack.add(i);
                }
            }
            int[] result=new int[stack.size()];
            for (int i=0;i<result.length;i++)
            {
                result[i]=stack.pop();
            }
            return result;
        }

    }

    public void backTrack(int[][] prerequisites,int cur)
    {
        if(visited[cur]==1)
        {
            ok=false;
            return;
        }
        if(visited[cur]==2)
        {
            return;
        }
        visited[cur]=1;
        for (int i:lists[cur])
        {
            backTrack(prerequisites,i);
        }
        visited[cur]=2;
        stack.add(cur);
        set.add(cur);
    }
    @Override
    public void test()
    {
        int[] result=findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}});
        for (int i:result)
        {
            System.out.print(i);
        }

    }
}
