package LeetCode.回溯法;

import LeetCode.Base.LeetCodeBase;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC40 implements LeetCodeBase
{
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        Arrays.sort(candidates);
        backTrack(candidates,target,new ArrayList<>(),0,0);
        return result;
    }

    public void  backTrack(int[] nums, int target,List<Integer> list,int cur,int begin)
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
                backTrack(nums,target,list,cur+nums[i],i+1);
                list.remove(list.size()-1);
                while (i+1<nums.length&&nums[i+1]==nums[i])
                {
                    i++;
                }
            }
        }
    }
    @Override
    public void test() {

    }
}
