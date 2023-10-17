package LeetCode.动态规划;

import LeetCode.Base.LeetCodeBase;

public class LC343 implements LeetCodeBase
{
    public int integerBreak(int n)
    {
        int[] dp=new int[n+1];
        dp[2]=1;
        for (int i=3;i<=n;i++)
        {
            for (int j=1;j<i;j++)
            {
                //j*(i-j)：拆分成两个
                //j*dp[i-j]：拆分成两个及以上
                dp[i]=Math.max(Math.max(j*(i-j),j*dp[i-j]),dp[i]);
            }
        }
        return dp[n];
    }
    @Override
    public void test()
    {
        System.out.println(integerBreak(10));

    }
}
