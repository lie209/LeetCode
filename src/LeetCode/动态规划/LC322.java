package LeetCode.动态规划;

import LeetCode.Base.LeetCodeBase;

import java.util.Arrays;
import java.util.HashMap;

public class LC322 implements LeetCodeBase
{
    HashMap<Integer,Integer> map=new HashMap<>();
    int result=Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount)
    {
        return dp(coins,amount);

    }

    public int dp(int[] coins, int amount)
    {
//        if(amount==0)
//        {
//            return 0;
//        }
//        //穷举获得最优解，所以要放到外面
//        int res=Integer.MAX_VALUE;
//        for (int i=0;i<coins.length;i++)
//        {
//            if(coins[i]<=amount)
//            {
//                int temp=map.containsKey(amount-coins[i])?map.get(amount-coins[i]):dp(coins,amount-coins[i]);
//                if(temp==-1)
//                {
//                    continue;
//                }
//                res=Math.min(temp+1,res);
//            }
//        }
//        int resTemp=res==Integer.MAX_VALUE?-1:res;
//        map.put(amount,resTemp);
//        return resTemp;

        //第二种思路，自底向上=========================================
//        int[] dp=new int[amount+1];
//        Arrays.fill(dp,amount+1);
//        dp[0]=0;
//        for (int i=1;i<dp.length;i++)
//        {
//            for(int j:coins)
//            {
//                if(i-j>=0)
//                {
//                    dp[i]=Math.min(dp[i],dp[i-j]+1);
//                }
//            }
//        }
//        return dp[amount]==amount+1?-1:dp[amount];
        if(amount==0)
        {
            return 0;
        }
        int res=Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++)
        {
            if(amount-coins[i]>=0)
            {

                int temp=map.containsKey(amount-coins[i])?map.get(amount-coins[i]):coinChange(coins,amount-coins[i]);
                if(temp==-1)
                {
                    continue;
                }
                res=Math.min(res,temp+1);
            }
        }
        map.put(amount,res==Integer.MAX_VALUE?-1:res);
        return res==Integer.MAX_VALUE?-1:res;
    }
    @Override
    public void test()
    {
//        System.out.println(coinChange(new int[]{186,419,83,408},6249));
//        System.out.println(coinChange(new int[]{1,2,5},11));
        System.out.println(coinChange(new int[]{2},3));
    }
}
