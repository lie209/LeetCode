package LeetCode.二分法;

import LeetCode.Base.LeetCodeBase;

import java.util.concurrent.TransferQueue;

public class LC209 implements LeetCodeBase
{
    public int minSubArrayLen(int target, int[] nums)
    {
        int[] preNums=prenums(nums);
        if(preNums[nums.length-1]==target)
        {
            return nums.length;
        }
        int i=0,j=0;
        int minLen=Integer.MAX_VALUE;
        for (j=0;j<nums.length;j++)
        {
            if(preNums[j]-preNums[i]+nums[i]<target)
            {
                continue;
            }
            else
            {
                while (i<=j&&preNums[j]-preNums[i]+nums[i]>=target)
                {
                    i++;
                }
                minLen=Math.min(minLen,j-i+2);
            }
        }
        return minLen==Integer.MAX_VALUE?0:minLen;
    }

    public int[] prenums(int[] nums)
    {
        int[] result=new int[nums.length];
        result[0]=nums[0];
        for (int i=1;i<nums.length;i++)
        {
            result[i]=result[i-1]+nums[i];
        }
        return result;
    }

    @Override
    public void test() {
        int[] nums=new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen(5,nums));
    }
}
