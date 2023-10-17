package LeetCode.动态规划;

import LeetCode.Base.LeetCodeBase;

import java.util.HashMap;

public class LC279 implements LeetCodeBase
{
    public int numSquares(int n)
    {
        int[] dp=new int[n+1];

        for (int i=1;i<=n;i++)
        {
            int temp=Integer.MAX_VALUE;
            for (int j=1;j*j<=i;j++)
            {
                //寻找去除当前完全平方数后的最小的组成次数
                temp=Math.min(dp[i-j*j],temp);
            }
            dp[i]=temp+1;
        }
        return dp[n];
    }

    @Override
    public void test()
    {
        System.out.println(numSquares(8));
//        System.out.println(numSquares(12));

    }
}
