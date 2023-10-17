package LeetCode.动态规划;

import LeetCode.Base.LeetCodeBase;

import java.util.Arrays;

public class LC712 implements LeetCodeBase
{
    int[][] visited;
    public int minimumDeleteSum(String s1, String s2)
    {
        visited=new int[s1.length()+1][s2.length()+1];
        for (int[] i:visited)
        {
            Arrays.fill(i,666);
        }
        return deleteNum(s1,s2,s1.length(),s2.length());
    }

    public int deleteNum(String s1,String s2,int i,int j)
    {
        if(visited[i][j]!=666)
        {
            return visited[i][j];
        }
        if(i==0)
        {
            char[] chars=s2.toCharArray();
            int sum=0;
            for (int k=0;k<j;k++)
            {
                sum=sum+chars[k];
            }
            visited[i][j]=sum;
            return sum;
        }
        if(j==0)
        {
            char[] chars=s1.toCharArray();
            int sum=0;
            for (int k=0;k<i;k++)
            {
                sum=sum+chars[k];
            }
            visited[i][j]=sum;
            return sum;
        }
        if(s1.charAt(i-1)==s2.charAt(j-1))
        {
            int temp=deleteNum(s1,s2,i-1,j-1);
            visited[i][j]=temp;
            return temp;
        }
        else
        {
            int temp=Math.min(deleteNum(s1,s2,i-1,j)+s1.charAt(i-1), deleteNum(s1,s2,i,j-1)+s2.charAt(j-1));
            visited[i][j]=temp;
            return temp;
        }
    }


    @Override
    public void test()
    {
        System.out.println(minimumDeleteSum("delete", "leet"));

    }
}
