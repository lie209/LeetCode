package LeetCode.动态规划;

import LeetCode.Base.LeetCodeBase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC518 implements LeetCodeBase
{

    //回溯法，出现了重复解
//    List<List<Integer>> lists=new ArrayList<>();
//    int result=0;
//    public int change(int amount, int[] coins)
//    {
//        backTrack(amount,coins,0,new ArrayList<>());
//        System.out.println(lists);
//        return result;
//
//    }
//    public void backTrack(int amount, int[] coins,int cur,List<Integer> list)
//    {
//        if(cur==amount)
//        {
//            result++;
//            lists.add(new ArrayList<>(list));
//            return;
//        }
//        for (int i=0;i<coins.length;i++)
//        {
//            if(cur+coins[i]<=amount)
//            {
//                list.add(coins[i]);
//                backTrack(amount,coins,cur+coins[i],list);
//                list.remove(list.size()-1);
//            }
//        }
//    }

    public int change(int amount, int[] coins)
    {
        //dp[i]表示，凑成i元的方法数
        int[] dp=new int[amount+1];
        dp[0]=1;
        for (int i=0;i<coins.length;i++)
        {
            for (int j=1;j<=amount;j++)
            {
                if(j>=coins[i])
                {
                    dp[j]=dp[j]+dp[j-coins[i]];
                }
            }
        }
        return dp[amount];
    }


    @Override
    public void test()
    {
        System.out.println(change(5,new int[]{1,2,5}));

    }
}
