package LeetCode.未分类;

import LeetCode.Base.LeetCodeBase;

public class LC34 implements LeetCodeBase
{
    public int[] run(int[] nums,int target)
    {
        int[] result = new int[]{-1,-1};
        if(nums.length==0)
        {
            return result;
        }
        if(nums.length==1)
        {
            if(nums[0]!=target)
            {
                return result;
            }
            else
            {
                return new int[] {
                   0,0
                };
            }
        }

        int left = 0,right = nums.length-1;
        while (left<=right)
        {
            if(nums[left]==target&&result[0]==-1)
            {
                result[0]=left;
            }
            else if(result[0]==-1)
            {
                left++;
            }
            if(nums[right]==target&&result[1]==-1)
            {
                result[1]=right;
            }
            else if(result[1]==-1)
            {
                right--;
            }
            if(result[0]!=-1&&result[1]!=-1)
            {
                return result;
            }
        }
        return result;
    }
    @Override
    public void test()
    {
        int[] res=run(new int[]{1,2,3},1);
        System.out.println(res[0]+" "+res[1]);
    }
}
