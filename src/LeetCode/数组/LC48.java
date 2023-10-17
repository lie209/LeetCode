package LeetCode.数组;

import LeetCode.Base.LeetCodeBase;

public class LC48 implements LeetCodeBase
{
    public void rotate(int[][] matrix)
    {
        int n=matrix.length;
        //规律题，先右上角和左下角交换转置，再左右镜像反转
        for (int i=0;i<n;i++)
        {
            for (int j=i+1;j<n;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for (int i=0;i<n;i++)
        {
            //注意这里不能等于n/2
            for (int j=0;j<n/2;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][n-j];
                matrix[i][n-j]=temp;
            }
        }
    }
    @Override
    public void test() {

    }
}
