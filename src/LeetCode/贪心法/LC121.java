package LeetCode.贪心法;

import LeetCode.Base.LeetCodeBase;

import java.time.Period;

public class LC121 implements LeetCodeBase
{
    public int maxProfit(int[] prices)
    {
        int min=Integer.MAX_VALUE;
        int result=Integer.MIN_VALUE;
        for (int i=1;i< prices.length;i++)
        {
            min=Math.min(prices[i-1],min );
            result=Math.max(result,prices[i]-min);
        }
        return result;
    }
    @Override
    public void test() {

    }
}
