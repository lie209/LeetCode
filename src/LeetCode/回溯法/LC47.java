package LeetCode.回溯法;

import LeetCode.Base.LeetCodeBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class LC47 implements LeetCodeBase
{
    List<List<Integer>> result=new ArrayList<>();
    int[] used;
    public List<List<Integer>> permuteUnique(int[] nums)
    {
        Arrays.sort(nums);
        used=new int[nums.length];
        backTrack(nums,new ArrayList<>(),0);
        return result;

    }

    public void backTrack(int[] nums,List<Integer> list,int begin)
    {
        if(list.size()==nums.length)
        {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i=begin;i<nums.length;i++)
        {
            if(used[i]==0)
            {
                used[i]=1;
                list.add(nums[i]);
                backTrack(nums,list,begin);
                used[i]=0;
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
        List<List<Integer>> list=permuteUnique(new int[]{3,3,0,3});
        System.out.println(list);

    }
}
