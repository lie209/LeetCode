package LeetCode.动态规划;

import LeetCode.Base.LeetCodeBase;

import javax.sql.rowset.FilteredRowSet;

public class LC63 implements LeetCodeBase
{
    public int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0]=obstacleGrid[0][0]==1?0:1;
        for (int i=1;i<m;i++)
        {
            dp[i][0]=obstacleGrid[i][0]==1?0:dp[i-1][0];
        }
        for (int i=1;i<n;i++)
        {
            dp[0][i]=obstacleGrid[0][i]==1?0:dp[0][i-1];
        }
        for (int i=1;i<m;i++)
        {
            for (int j=1;j<n;j++)
            {
                dp[i][j]=obstacleGrid[i][j]==1?0:dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    @Override
    public void test()
    {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,1},{0,0}}));
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,0}}));

    }
}
