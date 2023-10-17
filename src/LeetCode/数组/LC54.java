package LeetCode.数组;

import LeetCode.Base.LeetCodeBase;

import java.util.ArrayList;
import java.util.List;

public class LC54 implements LeetCodeBase
{
    public List<Integer> spiralOrder(int[][] matrix)
    {
        int m=matrix.length;
        int n=matrix[0].length;
        int i=0,j=0;
        List<Integer> result=new ArrayList<>();
        int[][] visited=new int[m][n];
        while (m>0&&n>0)
        {
            //上
            for (int k=j;k<j+n;k++)
            {
                if(visited[i][k]==0)
                {
                    result.add(matrix[i][k]);
                    visited[i][k]=1;
                }

            }
            //右
            for (int k=i+1;k<i+m;k++)
            {
                if(visited[k][j+n-1]==0)
                {
                    result.add(matrix[k][j+n-1]);
                    visited[k][j+n-1]=1;
                }

            }
            //下
            for (int k=j+n-2;k>=j;k--)
            {
                if(visited[i+m-1][k]==0)
                {
                    result.add(matrix[i+m-1][k]);
                    visited[i+m-1][k]=1;
                }

            }
            //左
            for (int k=i+m-2;k>i;k--)
            {
                if(visited[k][j]==0)
                {
                    result.add(matrix[k][j]);
                    visited[k][j]=1;
                }

            }
            m=m-2;
            n=n-2;
            i=i+1;
            j=j+1;
        }
        return result;

    }
    @Override
    public void test()
    {
        System.out.println(spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
        System.out.println(spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));

    }
}
