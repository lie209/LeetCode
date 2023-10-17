package LeetCode.二分法;

import LeetCode.Base.LeetCodeBase;

import java.time.chrono.MinguoChronology;

public class LC35 implements LeetCodeBase
{
    public int searchInsert(int[] nums, int target)
    {
        int left=0;
        int right=nums.length-1;
        int result=Integer.MAX_VALUE;
        while (left<=right)
        {
            int mid=(left+right)>>1;
            if(nums[mid]==target)
            {
                result=mid;
                break;
            }
            if(nums[mid]>target)
            {
                result=Math.min(mid,result);
                right=mid-1;
            }
            else
            {
                left=mid+1;
            }
        }
        return result==Integer.MAX_VALUE?nums.length:result;
    }


    @Override
    public void test()
    {
        System.out.println(searchInsert(new int[]{1,3,5,6},7));

    }
}
