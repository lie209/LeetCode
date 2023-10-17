package LeetCode.动态规划;

import LeetCode.Base.LeetCodeBase;

public class LC96 implements LeetCodeBase
{

    //动态规划解题，从前往后推导
    public int numTrees(int n)
    {
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i=2;i<=n;i++)
        {
            int count=0;
            //遍历以不同的数作为根节点的情况
            for (int j=1;j<=i;j++)
            {
                count=count+dp[j-1]*dp[i-j];
            }
            dp[i]=count;
        }
        return dp[n];
    }
    @Override
    public void test()
    {
        System.out.println(numTrees(2));

    }
}
