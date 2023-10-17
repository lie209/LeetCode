package LeetCode.未分类;

import LeetCode.Base.LeetCodeBase;

public class LC704 implements LeetCodeBase
{

    public int run(int[] nums,int target)
    {
        int left=0,right = nums.length-1;
        while (left<=right)
        {
            int mid=(left+right)/2;
            if(nums[mid]==target)
            {
                return mid;
            } else if (nums[mid]<target)
            {
                left = mid+1;
            }
            else if (nums[mid]>target)
            {
                right=mid-1;
            }
        }
        return -1;
    }
    @Override
    public void test()
    {
        System.out.println(run(new int[]{-1,0,3,5,9,12},2));
    }
}
