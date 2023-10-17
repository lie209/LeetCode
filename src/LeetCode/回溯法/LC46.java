package LeetCode.回溯法;

import LeetCode.Base.LeetCodeBase;

import java.util.ArrayList;
import java.util.List;

public class LC46 implements LeetCodeBase
{
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums)
    {
        int[] used=new int[nums.length];
        for(int i:used)
        {
            i=0;
        }
        List<Integer> temp=new ArrayList<>();
        backTrack(nums, used, temp);
        return result;
    }

    public void backTrack(int[] nums,int[] used,List<Integer> track)
    {
        if(track.size()==nums.length)
        {
            result.add(new ArrayList<>(track));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(used[i]==0)
            {
                //本次使用第i个数
                used[i]=1;
                track.add(nums[i]);
                backTrack(nums,used,track);
                //第i个数用过了，恢复成原样，不然会导致他始终是使用的状态
                track.remove(track.size()-1);
                used[i]=0;
            }
        }
    }
    @Override
    public void test() {

    }
}
