package LeetCode.动态规划;

import LeetCode.Base.LeetCodeBase;

import java.util.Arrays;

public class LC416 implements LeetCodeBase
{
    public boolean canPartition(int[] nums)
    {
        int sum=0;
        for (int i:nums)
        {
            sum=sum+i;
        }
        if(sum%2!=0)
        {
            return false;
        }
        int weigth=sum/2;

        int[][] dp=new int[nums.length][weigth+1];
        for (int i=0;i<nums.length;i++)
        {
            dp[i][0]=0;
        }
        for (int i=0;i<=weigth;i++)
        {
            dp[0][i]=i>=nums[0]?nums[0]:0;
        }

        for (int i=1;i<nums.length;i++)
        {
            for (int j=1;j<=weigth;j++)
            {
                //可以放下去
                if(j>=nums[i])
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-nums[i]]+nums[i]);
                }
                //放不下去
                else
                {
                    dp[i][j]=dp[i-1][j];
                }

            }
        }
        return dp[nums.length-1][weigth]==weigth;

    }

    @Override
    public void test()
    {
        System.out.println(canPartition(new int[]{1,5,10,6}));

    }
}
