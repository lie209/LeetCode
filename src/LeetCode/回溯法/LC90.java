package LeetCode.回溯法;

import LeetCode.Base.LeetCodeBase;

import java.util.*;

public class LC90 implements LeetCodeBase
{
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums)
    {
        Arrays.sort(nums);
        backTrack(nums,new ArrayList<>(),0);
        return result;

    }

    public void backTrack(int[] nums,List<Integer> list,int index)
    {

        result.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++)
        {
            list.add(nums[i]);
            backTrack(nums,list,i+1);
            list.remove(list.size()-1);
            while (i+1<nums.length&&nums[i+1]==nums[i])
            {
                i++;
            }
        }
    }
    @Override
    public void test()
    {
        List<List<Integer>> list=subsetsWithDup(new int[]{4,4,4,1,4});
        System.out.println(list);

    }
}
