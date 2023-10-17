package LeetCode.动态规划;

import LeetCode.Base.LeetCodeBase;

//01背包问题
public class LC1049 implements LeetCodeBase
{
    public int lastStoneWeightII(int[] stones)
    {
        int sum=0;
        for (int i:stones)
        {
            sum=sum+i;
        }
        int target=sum/2;
        int[][] dp=new int[stones.length][target+1];
        for (int i=0;i<stones.length;i++)
        {
            dp[i][0]=0;
        }
        for (int i=0;i<=target;i++)
        {
            dp[0][i]=i>=stones[0]?stones[0]:0;
        }
        for (int i=1;i<stones.length;i++)
        {
            for (int j=1;j<=target;j++) {
                if(j>=stones[i])
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-stones[i]]+stones[i]);
                }
                else
                {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        int a=dp[stones.length-1][target];
        return Math.abs(sum-a-a);
    }

    @Override
    public void test() {

    }
}
