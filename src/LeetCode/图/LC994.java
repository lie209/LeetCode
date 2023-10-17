package LeetCode.图;

import LeetCode.Base.LeetCodeBase;

import javax.swing.*;
import java.net.http.HttpRequest;
import java.util.LinkedList;
import java.util.Queue;

public class LC994 implements LeetCodeBase
{
    public int orangesRotting(int[][] grid)
    {
        Queue<int[]> queue=new LinkedList<>();
        int count1=0;
        for (int i=0;i<grid.length;i++)
        {
            for (int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                {
                    queue.add(new int[]{i,j});
                }
                if(grid[i][j]==1)
                {
                    count1++;
                }
            }
        }
        if(count1==0)
        {
            return 0;
        }
        int minues=0;
        while (!queue.isEmpty())
        {
            int size=queue.size();
            for (int i=0;i<size;i++)
            {
                int[] orange=queue.poll();
                //上面的
                if(orange[0]-1>=0&&grid[orange[0]-1][orange[1]]==1)
                {
                    queue.add(new int[]{orange[0]-1,orange[1]});
                    grid[orange[0]-1][orange[1]]=2;
                    count1--;
                }
                //右边的
                if(orange[1]+1<grid[0].length&&grid[orange[0]][orange[1]+1]==1)
                {
                    queue.add(new int[]{orange[0],orange[1]+1});
                    grid[orange[0]][orange[1]+1]=2;
                    count1--;
                }
                //下面的
                if(orange[0]+1<grid.length&&grid[orange[0]+1][orange[1]]==1)
                {
                    queue.add(new int[]{orange[0]+1,orange[1]});
                    grid[orange[0]+1][orange[1]]=2;
                    count1--;
                }
                //左边的
                if(orange[1]-1>=0&&grid[orange[0]][orange[1]-1]==1)
                {
                    queue.add(new int[]{orange[0],orange[1]-1});
                    grid[orange[0]][orange[1]-1]=2;
                    count1--;
                }
            }
            minues++;
        }
        return count1>0?-1:minues-1;
    }

    @Override
    public void test()
    {
        System.out.println(orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
        System.out.println(orangesRotting(new int[][]{{1,2}}));

    }
}
