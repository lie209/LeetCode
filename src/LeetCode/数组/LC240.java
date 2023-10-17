package LeetCode.数组;

import java.lang.annotation.Target;

public class LC240
{
    //方法一：回溯法
//    boolean result=false;
//    int[][] visited;
//    public boolean searchMatrix(int[][] matrix, int target)
//    {
//        visited=new int[matrix.length][matrix[0].length];
//        backTrack(matrix,0,0,target);
//        return result;
//
//    }
//
//    public void backTrack(int[][] matrix,int i,int j,int target)
//    {
//        if(i>matrix.length||j>matrix[0].length)
//        {
//            return;
//        }
//        if(visited[i][j]==1)
//        {
//            return;
//        }
//        if(matrix[i][j]==target)
//        {
//            result=true;
//        }
//        visited[i][j]=1;
//        if(i+1<matrix.length&&matrix[i+1][j]<=target)
//        {
//            backTrack(matrix,i+1,j,target);
//        }
//        if(j+1<matrix[0].length&&matrix[i][j+1]<=target)
//        {
//            backTrack(matrix,i,j+1,target);
//        }
//    }
    //方法二：从右上角看，是一颗二叉搜索树
    public boolean searchMatrix(int[][] matrix, int target)
    {
        int i=0;
        int j=matrix[0].length-1;
        boolean result=false;
        while (i<=matrix.length-1&&j>=0)
        {
            if(matrix[i][j]==target)
            {
                result=true;
            }
            if(matrix[i][j]>target)
            {
                j=j-1;
            }else
            {
                i=i+1;
            }
        }
        return result;
    }
}
