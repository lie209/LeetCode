package LeetCode.复习;

import LeetCode.Base.LeetCodeBase;

import java.util.ArrayList;
import java.util.List;

public class LC47 implements LeetCodeBase
{
    List<List<Integer>> result=new ArrayList<>();
    int[] used;
    public List<List<Integer>> permuteUnique(int[] nums)
    {
        used=new int[nums.length];
        backTrack(nums,new ArrayList<>());
        return result;
    }

    public void backTrack(int[] nums,List<Integer> list)
    {
        if(list.size()==nums.length)
        {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i=0;i<nums.length;i++)
        {
            if(used[i]==1)
            {
                continue;
            }
            used[i]=1;
            list.add(nums[i]);
            backTrack(nums,list);
            list.remove(list.size()-1);
            used[i]=0;
            while (i+1<nums.length&&nums[i]==nums[i+1])
            {
                i++;
            }
        }
    }
    @Override
    public void test()
    {
        System.out.println(permuteUnique(new int[]{1,2,3}));

    }
}
