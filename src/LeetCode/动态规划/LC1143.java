package LeetCode.动态规划;

import LeetCode.Base.LeetCodeBase;

public class LC1143 implements LeetCodeBase
{
    public int longestCommonSubsequence(String text1, String text2)
    {
        int m=text1.length();
        int n=text2.length();
        int[][] dp=new int[m+1][n+1];
        //空字符串之间的公共子序列的长度为0
        for (int i = 0; i <=m; i++)
        {
            dp[i][0]=0;
        }
        for (int i = 0; i <=n; i++)
        {
            dp[0][i]=0;
        }
        for (int i = 1; i <=m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                //如果两个字符串的当前字符相等，则公共子序列的长度等于两个字符串的前一个字符的公共子序列的长度+1
                //上一个状态+1
                if(text1.charAt(i-1)==text2.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                //如果不相等，取两个字符串上一个状态的最大值，因为需要求最长的公共子序列
                else
                {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
    @Override
    public void test() {

    }
}
