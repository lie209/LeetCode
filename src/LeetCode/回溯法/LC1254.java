package LeetCode.回溯法;

import LeetCode.Base.LeetCodeBase;

import javax.swing.*;

public class LC1254 implements LeetCodeBase
{
    int m,n;
    int[][] visited;
    public int closedIsland(int[][] grid)
    {
        m=grid.length;
        n=grid[0].length;
        visited=new int[m][n];
        int result=0;
        for (int i=0; i<m; i++)
        {
            if(i==0)
            {
                for (int j=0;j<n;j++)
                {
                    if(grid[0][j]==0)
                    {
                        backTrack(grid,0,j);
                    }
                }
            }
            if(i!=0&&grid[i][0]==0)
            {
                backTrack(grid,i,0);
            }
            if(i!=0&&grid[i][n-1]==0)
            {
                backTrack(grid,i,n-1);
            }
            if(i==m-1)
            {
                for (int j=0;j<n;j++)
                {
                    if(grid[m-1][j]==0)
                    {
                        backTrack(grid,m-1,j);
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j=0;j<n;j++)
            {
                if(grid[i][j]==0&&visited[i][j]==0)
                {
                    result++;
                    backTrack(grid,i,j);
                }
            }
        }
        return result;
    }

    public void backTrack(int[][] grid, int i, int j)
    {

        if (i<0 || i>=m || j<0 || j>=n)
            return;
        if(visited[i][j]==1)
        {
            return;
        }
        visited[i][j]=1;
        if(grid[i][j]==1)
        {
            return;
        }
        grid[i][j]=1;
        backTrack(grid,i-1,j);
        backTrack(grid, i+1, j);
        backTrack(grid, i, j+1);
        backTrack(grid, i, j-1);
    }
    @Override
    public void test() {

    }
}
