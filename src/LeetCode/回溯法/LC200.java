package LeetCode.回溯法;

import LeetCode.Base.LeetCodeBase;

public class LC200 implements LeetCodeBase
{
    int result;
    int m,n;
    int[][] visited;
    //把访问过的陆地以及旁边的陆地都淹掉
    public int numIslands(char[][] grid)
    {
        m=grid.length;
        n= grid[0].length;
        visited=new int[m][n];
        for (int i=0;i<m;i++)
        {
            for (int j=0;j<n;j++)
            {
                if (grid[i][j]=='1' && visited[i][j]==0)
                {
                    result++;
                    backTrack(grid,i,j);
                }
            }
        }
        return result;
    }

    public void backTrack(char[][] grid, int i,int j)
    {
        if(i<0 || i>=m || j<0 || j>=n)
            return;
        if(visited[i][j]==1)
            return;
        visited[i][j]=1;
        if(grid[i][j]=='0')
        {
            return;
        }
        else
        {
            grid[i][j]='0';
            backTrack(grid, i-1, j);
            backTrack(grid, i, j-1);
            backTrack(grid, i, j+1);
            backTrack(grid, i+1, j);
        }

    }


    @Override
    public void test() {

    }
}
