package LeetCode.复习;

import LeetCode.Base.LeetCodeBase;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.ListIterator;

public class LC39 implements LeetCodeBase
{
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        backTrack(candidates,target,0,new ArrayList<>(),0);
        return result;
    }
    public void backTrack(int[] candidates, int target, int cur, List<Integer> list,int index)
    {
        if(cur==target)
        {
            result.add(new ArrayList<>(list));
        }
        for (int i=index;i<candidates.length;i++)
        {
            if(cur+candidates[i]<=target)
            {
                list.add(candidates[i]);
                backTrack(candidates,target,cur+candidates[i],list,i);
                list.remove(list.size()-1);
            }
        }
    }
    @Override
    public void test()
    {
        System.out.println(combinationSum(new int[]{2,3,6,7},7));

    }
}
