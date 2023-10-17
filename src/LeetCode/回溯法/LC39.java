package LeetCode.回溯法;

import LeetCode.Base.LeetCodeBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC39 implements LeetCodeBase
{
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        backTrack(candidates,target,0,new ArrayList<>(),0);
        return result;
    }

    public void backTrack(int[] nums,int target,int cur,List<Integer> list,int begin)
    {
        if(cur==target)
        {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i=begin;i<nums.length;i++)
        {
            if(cur+nums[i]<=target)
            {
                list.add(nums[i]);
                //不能用前面用过的
                backTrack(nums,target,cur+nums[i],list,i);
                list.remove(list.size()-1);
            }
        }
    }
    @Override
    public void test()
    {
        List<List<Integer>> list=combinationSum(new int[]{7,3,2},18);
        System.out.println(list);
    }

}
