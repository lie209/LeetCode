package LeetCode.动态规划;

import LeetCode.Base.LeetCodeBase;

import javax.swing.plaf.PanelUI;
import java.util.Arrays;

public class LC583 implements LeetCodeBase
{
    int[][] visited;
    public int minDistance(String word1, String word2)
    {
        visited=new int[word1.length()+1][word2.length()+1];
        for (int[] i:visited)
        {
            Arrays.fill(i,666);
        }
        return dp(word1,word2,word1.length(),word2.length());
    }
    public int dp(String word1, String word2,int i,int j)
    {
        if(visited[i][j]!=666)
        {
            return visited[i][j];
        }
        if(i==0)
        {
            visited[i][j]=j;
            return j;
        }
        if(j==0)
        {
            visited[i][j]=i;
            return i;
        }
        if(word1.charAt(i-1)==word2.charAt(j-1))
        {
            //相同则不删除
            int temp=dp(word1,word2,i-1,j-1);
            visited[i][j]=temp;
            return temp;
        }
        else
        {
            //删除任意一个，取步数最小的
            int temp=Math.min(dp(word1,word2,i-1,j),dp(word1,word2,i,j-1))+1;
            visited[i][j]=temp;
            return temp;
        }
    }
    @Override
    public void test()
    {
//        System.out.println(minDistance("leetcode", "etco"));
        System.out.println(minDistance("sea", "eat"));

    }
}
