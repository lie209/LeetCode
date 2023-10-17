package LeetCode.回溯法;

import LeetCode.Base.LeetCodeBase;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC1905 implements LeetCodeBase
{
    int m,n;
    int[][] visited1,visited2;
    int[][] grid3;
    public int countSubIslands(int[][] grid1, int[][] grid2)
    {
        m=grid1.length;
        n=grid1[0].length;
        grid3=grid1;
        visited1=new int[m][n];
        visited2=new int[m][n];

        int result=0;
        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++)
            {
                if(grid2[i][j]==1&&grid1[i][j]==0)
                {
                    backTrack(grid2,visited2,i,j,new ArrayList<>());
                }
            }
        }
        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++)
            {
                if(grid2[i][j]==1&&visited2[i][j]==0)
                {
                    result++;
                    backTrack(grid2,visited2,i,j,new ArrayList<>());
                }
            }
        }
        return result;


    }



    public List<Integer> backTrack(int[][] grid,int[][] visited,int i,int j,List<Integer> list)
    {
        if(i<0||j<0||i>=m||j>=n||visited[i][j]==1||grid[i][j]==0)
        {
            return list;
        }
        visited[i][j]=1;
        if(grid[i][j]==grid3[i][j])

        grid[i][j]=0;
        list.add(grid[i][j]);
        backTrack(grid,visited,i,j-1, list);
        backTrack(grid,visited,i,j+1,list);
        backTrack(grid,visited,i+1, j,list);
        backTrack(grid,visited,i-1,j,list);
        return list;
    }

    @Override
    public void test()
    {
        int[][] grid1=new int[][]{{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}};
        int[][] grid2=new int[][]{{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}};
        System.out.println(countSubIslands(grid1,grid2));

    }
}
