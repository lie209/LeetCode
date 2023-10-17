package LeetCode.动态规划;

import LeetCode.Base.LeetCodeBase;

public class LC746 implements LeetCodeBase
{
    public int minCostClimbingStairs(int[] cost)
    {
        int n=cost.length;
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=0;
        for (int i=2;i<=n;i++)
        {
            dp[i]=Math.min(cost[i-1]+dp[i-1],cost[i-2]+dp[i-2]);
        }
        return dp[n];
    }
    @Override
    public void test()
    {
//        System.out.println(minCostClimbingStairs(new int[]{10,15,20}));
        System.out.println(minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));

    }
}
