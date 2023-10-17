package LeetCode.动态规划;

import LeetCode.Base.LeetCodeBase;

public class LC152 implements LeetCodeBase
{
    //乘积最大子数组
    public int maxProduct(int[] nums)
    {
        int result=nums[0];
        //两个数组分别表示到当前下标时的最大乘积和最小乘积，正数乘以最大乘积得到最大值，负数乘以最小乘积得最小值
        int[] minF=new int[nums.length];
        int[] maxF=new int[nums.length];
        for (int i=0;i<nums.length;i++)
        {
            minF[i]=nums[i];
            maxF[i]=nums[i];
        }
        for (int i=1;i<nums.length;i++)
        {
            maxF[i]=Math.max(nums[i],Math.max(nums[i]*maxF[i-1],nums[i]*minF[i-1]));
            minF[i]=Math.min(nums[i],Math.min(nums[i]*minF[i-1],nums[i]*maxF[i-1]));
            result=Math.max(result,maxF[i]);
        }
        return result;
    }
    @Override
    public void test()
    {
//        System.out.println(maxProduct(new int[]{2,3,-2,4}));
        System.out.println(maxProduct(new int[]{-2,3,-4}));

    }
}
