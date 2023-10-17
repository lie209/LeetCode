package LeetCode.图;
import LeetCode.Base.LeetCodeBase;
import java.util.*;

public class LC207 implements LeetCodeBase
{
    int[] visited;
    boolean result=true;
    public boolean canFinish(int numCourses, int[][] prerequisites)
    {
        if(prerequisites.length==0)
        {
            return true;
        }
        LinkedHashMap<Integer,List<Integer>> courses=new LinkedHashMap<>();
        for (int[] i:prerequisites)
        {
            List<Integer> list=courses.getOrDefault(i[1],new ArrayList<>());
            list.add(i[0]);
            courses.put(i[1],list);
        }

        visited=new int[numCourses];
        for (int i:courses.keySet())
        {
            backTrack(courses,i);
        }

        return result;

    }

    public void backTrack(HashMap<Integer,List<Integer>> courses,int cur)
    {
        if(visited[cur]==1)
        {
            result=false;
            return;
        }
        visited[cur]=1;
        if(courses.containsKey(cur))
        {
            for (int i:courses.get(cur))
            {
                backTrack(courses,i);
            }
        }
        visited[cur]=2;
    }
    @Override
    public void test()
    {
        System.out.println(canFinish(2,new int[][]{{0,1}}));
        System.out.println(canFinish(2,new int[][]{{1,0},{0,1}}));
        System.out.println(canFinish(20,new int[][]{{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}}));
        System.out.println(canFinish(5,new int[][]{{1,4},{2,4},{3,1},{3,2}}));
    }
}
