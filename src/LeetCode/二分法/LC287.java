package LeetCode.二分法;

import LeetCode.Base.LeetCodeBase;

public class LC287 implements LeetCodeBase
{
    public int findDuplicate(int[] nums)
    {
        int left=1,right=nums.length-1;
        while(left<right)
        {
            int mid=left+(right-left)/2;
            int count=0;
            for(int i=0;i<nums.length;i++) {
                if(nums[i]<=mid)
                    count++;
            }
            if(count>mid)
            {
                right=mid;
            }
            else
            {
                left=mid+1;
            }
        }
        return  left;
    }
    @Override
    public void test()
    {
//        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(findDuplicate(new int[]{3,1,3,4,2}));

    }
}
