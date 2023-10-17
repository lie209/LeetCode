package LeetCode.数组;

import LeetCode.Base.LeetCodeBase;

public class LC189 implements LeetCodeBase
{
    public void rotate(int[] nums, int k)
    {
        int[] result=new int[nums.length];
        for (int i=0;i<nums.length;i++)
        {
            int index=(i+k)%nums.length;
            result[index]=nums[i];
        }
        for (int i=0;i<nums.length;i++)
        {
            nums[i]=result[i];
        }

    }
    @Override
    public void test() {

    }
}
