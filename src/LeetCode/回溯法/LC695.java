package LeetCode.回溯法;

import LeetCode.Base.LeetCodeBase;

public class LC695 implements LeetCodeBase
{
    int m,n;
    int[][] visited;
    int temp=0;
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new int[m][n];
        int max = 0;
        for ( int i = 0; i < m; i++ ) {
            for (int j=0;j<n;j++)
            {
                if(grid[i][j]==1&&visited[i][j]==0)
                {
                    temp=0;
                    backTrack(grid,i,j);
                    max=Math.max(temp,max);
                }
            }
        }
        return max;

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
        if(grid[i][j]==0)
        {
            return;
        }
        grid[i][j]=0;
        temp++;
        backTrack(grid,i-1,j);
        backTrack(grid, i+1, j);
        backTrack(grid, i, j+1);
        backTrack(grid, i, j-1);
    }
    @Override
    public void test() {

    }
}
