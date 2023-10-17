package LeetCode.未分类;

import LeetCode.Base.LeetCodeBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class YongYouS4_2 implements LeetCodeBase
{
    HashMap<Integer, List<Integer>> map=new HashMap<>();
    HashMap<String,Integer> costMap=new HashMap<>();
    int[] visited;
    int result=Integer.MAX_VALUE;
    public void problem(int[][] nums,int n)
    {
        visited=new int[n+1];
        for (int[] i:nums)
        {
            List<Integer> list1=map.getOrDefault(i[0],new ArrayList<>());
            list1.add(i[1]);
            map.put(i[0],list1);
            List<Integer> list2=map.getOrDefault(i[1],new ArrayList<>());
            list2.add(i[0]);
            map.put(i[1],list2);
            costMap.put(i[0]+"#"+i[1],i[2]);
            costMap.put(i[1]+"#"+i[0],i[2]);
        }
        List<Integer> list=new ArrayList<>();
        visited[nums[0][0]]=1;
        list.add(nums[0][0]);
        backTrack(n,nums[0][0],list,0);
        System.out.println(result);
    }

    public void backTrack(int n,int cur,List<Integer> list,int cost)
    {
        if(list.size()==n&&result>cost)
        {
            result=cost;
            return;
        }
        for (int i:map.get(cur))
        {
            if(visited[i]==0)
            {
                visited[i]=1;
                list.add(i);
                backTrack(n,i,list,cost+costMap.get(cur+"#"+i));
                list.remove(list.size()-1);
                visited[i]=0;
            }
        }
    }

    @Override
    public void test()
    {
        problem(new int[][]{{1,2,5},{1,3,6},{2,3,1}},3);

    }
}
