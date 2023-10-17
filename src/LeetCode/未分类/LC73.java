package LeetCode.未分类;

import LeetCode.Base.LeetCodeBase;

import java.util.HashSet;

public class LC73 implements LeetCodeBase
{
    public void setZeroes(int[][] matrix)
    {
        HashSet<Integer> rows=new HashSet<>();
        HashSet<Integer> clomns=new HashSet<>();
        for (int i=0;i<matrix.length;i++)
        {
            for (int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==0)
                {
                    rows.add(i);
                    clomns.add(j);
                }
            }
        }
        for (int i:rows)
        {
            for (int j=0;j<matrix[0].length;j++)
            {
                matrix[i][j]=0;
            }
        }
        for (int j:clomns)
        {
            for (int i=0;i<matrix.length;i++)
            {
                matrix[i][j]=0;
            }
        }

    }

    @Override
    public void test() {

    }
}
