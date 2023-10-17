package LeetCode.复习;

import LeetCode.Base.LeetCodeBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class LC90 implements LeetCodeBase
{
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums)
    {
        Arrays.sort(nums);
        backTrack(nums,0,new ArrayList<>());
        return result;

    }

    public void backTrack(int[] nums,int index,List<Integer> list)
    {
        result.add(new ArrayList<>(list));
        System.out.println(list);
        for (int i=index;i<nums.length;i++)
        {
            list.add(nums[i]);
            backTrack(nums,i+1,list);
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
        System.out.println(subsetsWithDup(new int[]{4,4,4,1,4}));

    }
}
