package LeetCode.回溯法;

import LeetCode.Base.LeetCodeBase;

//本题同1254题
public class LC1020 implements LeetCodeBase {
    int m,n;
    int[][] visited;
    int result=0;
    public int numEnclaves(int[][] grid)
    {
        m=grid.length;
        n=grid[0].length;
        visited=new int[m][n];

        for (int i=0;i<m;i++)
        {
            backTrack(grid,i,0);
            backTrack(grid, i,n-1);
        }
        for (int j=0;j<n;j++)
        {
            backTrack(grid,0,j);
            backTrack(grid,m-1,j);
        }
        for (int i = 0; i < m; i++) {
            for (int j=0;j<n;j++)
            {
                if(grid[i][j]==1&&visited[i][j]==0)
                {
                    backTrack1(grid,i,j);
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
        if(grid[i][j]==0)
        {
            return;
        }
        grid[i][j]=0;
        backTrack(grid,i-1,j);
        backTrack(grid, i+1, j);
        backTrack(grid, i, j+1);
        backTrack(grid, i, j-1);
    }
    public void backTrack1(int[][] grid, int i, int j)
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
        result++;
        backTrack1(grid,i-1,j);
        backTrack1(grid, i+1, j);
        backTrack1(grid, i, j+1);
        backTrack1(grid, i, j-1);
    }


    @Override
    public void test() {
        int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        System.out.println(numEnclaves(grid));
    }
}
