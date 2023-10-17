package LeetCode.二分法;

import LeetCode.Base.LeetCodeBase;

public class LC977 implements LeetCodeBase
{
    public int[] sortedSquares(int[] nums)
    {
        int i=0,j=nums.length-1;
        int[] result=new int[nums.length];
        int k=j;
        while (i<=j)
        {
            if(nums[i]*nums[i]<nums[j]*nums[j])
            {
                result[k]=nums[j]*nums[j];
                k--;
                j--;
            }
            else
            {
                result[k]=nums[i]*nums[i];
                k--;
                i++;
            }
        }
        return result;
    }
    @Override
    public void test()
    {


    }
}
