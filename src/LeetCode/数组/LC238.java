package LeetCode.数组;

import LeetCode.Base.LeetCodeBase;

//巧妙技巧，左右累乘，记录每个元素左右的乘积即可
public class LC238 implements LeetCodeBase
{
    public int[] productExceptSelf(int[] nums)
    {
        int[] leftMult=new int[nums.length];
        leftMult[0]=nums[0];
        int[] rightMult=new int[nums.length];
        rightMult[nums.length-1]=nums[nums.length-1];
        for (int i=1;i<nums.length;i++)
        {
            leftMult[i]=leftMult[i-1]*nums[i];
        }
        for (int i=nums.length-2;i>=0;i--)
        {
            rightMult[i]=rightMult[i+1]*nums[i];
        }
        int[] result=new int[nums.length];
        result[0]=rightMult[1];
        result[nums.length-1]=leftMult[nums.length-2];
        for (int i=1;i<nums.length-1;i++)
        {
            result[i]=leftMult[i-1]*rightMult[i+1];
        }
        return result;
    }

    @Override
    public void test() {

    }
}
