package LeetCode.动态规划;

import LeetCode.Base.LeetCodeBase;

public class LC70 implements LeetCodeBase
{
    public int climbStairs(int n)
    {
        if(n==1||n==2)
        {
            return n;
        }
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for (int i=3;i<=n;i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    @Override
    public void test()
    {
        System.out.println(climbStairs(3));

    }
}
