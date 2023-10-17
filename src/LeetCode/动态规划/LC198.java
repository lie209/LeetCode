package LeetCode.动态规划;

import LeetCode.Base.LeetCodeBase;

import javax.sound.midi.Soundbank;

public class LC198 implements LeetCodeBase
{
    public int rob(int[] nums)
    {
        if (nums.length==1)
        {
            return nums[0];
        }
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        //要么偷，要么不偷
        dp[1]=Math.max(dp[0],nums[1]);
        int result=Math.max(dp[0],dp[1]);
        for (int i=2;i<nums.length;i++)
        {
            //不偷或者偷一家
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
            result=Math.max(result,dp[i]);
        }
        return result;
    }

    @Override
    public void test()
    {
//        System.out.println(rob(new int[]{2,7,9,3,1}));
//        System.out.println(rob(new int[]{1,1}));
        System.out.println(rob(new int[]{2,1,1,2}));

    }
}
