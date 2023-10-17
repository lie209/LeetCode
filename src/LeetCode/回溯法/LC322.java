package LeetCode.回溯法;

import LeetCode.Base.LeetCodeBase;

import java.util.LinkedList;
import java.util.List;

//回溯法解决此问题会超时
public class LC322 implements LeetCodeBase
{
    int result=Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount)
    {
        backTrack(coins,0,amount,new LinkedList<>());
        return result==Integer.MAX_VALUE?-1:result;
    }

    public void backTrack(int[] coins, long cur, int target, List<Integer> list)
    {
        if(cur==target)
        {
            result=Math.min(list.size(), result);
            return;
        }
        for (int i=0;i<coins.length;i++)
        {
            if(cur+coins[i]<=target)
            {
                list.add(coins[i]);
                backTrack(coins,cur+coins[i],target,list);
                list.remove(list.size()-1);//回溯)
            }
        }
    }
    @Override
    public void test()
    {
        System.out.println(coinChange(new int[]{1,2,5},100));

    }
}
