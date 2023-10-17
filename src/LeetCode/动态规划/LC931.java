package LeetCode.动态规划;

import LeetCode.Base.LeetCodeBase;

public class LC931 implements LeetCodeBase
{
    public int minFallingPathSum(int[][] matrix)
    {
        int[][] dp = new int[matrix.length][matrix[0].length];
        //初始化第一行
        for (int i=0;i<dp.length;i++)
        {
            dp[0][i]=matrix[0][i];

        }

        for (int i = 1; i < dp.length; i++)
        {
            for (int j = 0; j < dp[0].length; j++)
            {
                dp[i][j]=Integer.MAX_VALUE;
                for (int k=j-1;k<=j+1;k++)
                {
                    if(k>=0&&k<dp[0].length)
                    {
                        dp[i][j]=Math.min(dp[i][j],dp[i-1][k]+matrix[i][j]);
                    }

                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp[0].length; i++)
        {
            min = Math.min(min,dp[dp.length-1][i]);
        }
        return min;
    }


    @Override
    public void test()
    {
        System.out.println(minFallingPathSum(new int[][]{{2,1,3},{6,5,4},{7,8,9}}));

    }
}
