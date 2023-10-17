package LeetCode.回溯法;

import LeetCode.Base.LeetCodeBase;

import java.util.ArrayList;
import java.util.List;

public class LC51 implements LeetCodeBase
{
    List<List<String>> result=new ArrayList<>();
    public List<List<String>> solveNQueens(int n)
    {
        if(n==1)
        {
            List<String> l=new ArrayList<>();
            l.add("Q");
            result.add(l);
            return result;
        }
        int[][] used=new int[n][n];
        for (int i=0;i<n;i++)
        {
            for (int j=0;j<n;j++)
            {
                used[i][j]=0;
            }
        }
        backTrack(used,0,new ArrayList<String>());
        return result;

    }


    public void backTrack(int[][] used,int row,List<String> list) {
        if (row == used.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i=0;i<used[0].length;i++)
        {
            if(isValid(used, row,i))
            {
                used[row][i]=1;
                StringBuilder sb=new StringBuilder();
                for (int j = 0; j < used[0].length; j++)
                {
                    if(used[row][j]==1)
                    {
                        sb.append("Q");
                    }
                    else
                    {
                        sb.append(".");
                    }


                }
                list.add(sb.toString());
                System.out.println(sb);
                backTrack(used,row+1,list);
                list.remove(list.size()-1);
                used[row][i]=0;
            }
        }
    }

    public boolean isValid(int[][] used, int row, int col)
    {
        int n = used.length;
        //同一列是否有冲突
        for (int i = 0; i < n; i++) {
            if (used[i][col] ==1)
                return false;
        }
        //右斜线判断
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {
            if (used[i][j] ==1)
                return false;
        }
        //左斜线判断
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (used[i][j] ==1)
                return false;
        }
        return true;
    }


    @Override
    public void test()
    {
        List<List<String>> list=solveNQueens(4);
        for (List<String> i:list)
        {
            for (String j:i)
            {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
