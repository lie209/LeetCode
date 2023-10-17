package LeetCode.动态规划;

import LeetCode.Base.LeetCodeBase;

import java.util.Arrays;
import java.util.HashMap;

public class LC64 implements LeetCodeBase
{
    int m,n;
    int[][] visited;
    public int minPathSum(int[][] grid)
    {
        m=grid.length;
        n=grid[0].length;
        visited=new int[m][n];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(visited[i],-1);
        }


//        if(grid.length==0)
//        {
//            return 0;
//        }
//        grid[0][0]=grid[0][0];
//        //初始化第一行
//        for(int i=1;i<grid[0].length;i++)
//        {
//            grid[0][i]=grid[0][i-1]+grid[0][i];
//        }
//        for (int i = 1; i < grid.length; i++)
//        {
//            for (int j= 0; j < grid[0].length; j++)
//            {
//                if(j==0)
//                {
//                    grid[i][j]=grid[i-1][j]+grid[i][j];
//                }
//                else
//                {
//                    grid[i][j]=Math.min(grid[i-1][j],grid[i][j-1])+grid[i][j];
//                }
//            }
//        }
//        return grid[grid.length-1][grid[0].length-1];

        //第二种，递归法============================
        return dp(grid,m-1,n-1);
    }

    public int dp(int[][] grid,int i,int j)
    {
        if(i==0&&j==0)
        {
            visited[i][j]=grid[0][0];
            return grid[0][0];
        }
        if(i<0||i>m||j<0||j>n)
        {
            return Integer.MAX_VALUE;
        }
        if(visited[i][j]!=-1)
        {
            return visited[i][j];
        }
        visited[i][j]=Math.min(dp(grid,i-1,j),dp(grid,i,j-1))+grid[i][j];
        return visited[i][j];
    }

    @Override
    public void test() {

    }
}
