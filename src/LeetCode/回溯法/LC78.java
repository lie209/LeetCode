package LeetCode.回溯法;

import LeetCode.Base.LeetCodeBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC78 implements LeetCodeBase
{
    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums)
    {
        backTrack(nums,new ArrayList<>(),0);
        return result;
    }

    public void backTrack(int[] nums,List<Integer> list,int depth)
    {
        result.add(new ArrayList<>(list));
        for (int i=depth;i<nums.length;i++)
        {
            list.add(nums[i]);
            backTrack(nums,list,i+1);
            list.remove(list.size()-1);
        }
    }

    @Override
    public void test() {
        List<List<Integer>> list=subsets(new int[]{1,2,2});
        System.out.println(list);
    }
}
