package LeetCode.动态规划;

import LeetCode.Base.LeetCodeBase;

public class LC53 implements LeetCodeBase
{
    public int maxSubArray(int[] nums)
    {
        //暴力法，超时
//        int[] preNums=new int[nums.length];
//        preNums[0]=nums[0];
//        int maxValue=nums[0];
//        for (int i = 1; i < nums.length; i++)
//        {
//            preNums[i]=preNums[i-1]+nums[i];
//            for (int j=0;j<=i;j++)
//            {
//                maxValue=Math.max(maxValue,preNums[i]-preNums[j]+nums[j]);
//            }
//        }
//        return maxValue;

        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int maxValue=nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            maxValue=Math.max(maxValue,dp[i]);
        }
        return maxValue;
    }



    @Override
    public void test()
    {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
//        System.out.println(maxSubArray(new int[]{-1}));
//        System.out.println(maxSubArray(new int[]{-2,1}));
//        System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));

    }
}
