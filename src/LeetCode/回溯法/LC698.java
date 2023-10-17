package LeetCode.回溯法;

import LeetCode.Base.LeetCodeBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC698 implements LeetCodeBase
{
    public boolean canPartitionKSubsets(int[] nums, int k)
    {
        int sum=0;
        for (int num:nums)
        {
            sum=sum+num;
        }
        if(sum%k!=0)
        {
            return false;
        }
        Arrays.sort(nums);
        //要装的目标值
        int target=sum/k;
        int[] used=new int[nums.length];
        return backtrack(nums,nums.length-1,k,used,0,target);
    }


    public boolean backtrack(int[] nums,int end,int k,int[] used,int cur,int target)
    {
        if(k==1)
        {
            return true;
        }
        //当前直接满足了
        if(cur==target)
        {
            return backtrack(nums,nums.length-1,k-1,used,0,target);
        }
        for (int i=end;i>=0;i--)
        {
            if(used[i]==1||cur+nums[i]>target)
            {
                continue;
            }
            used[i]=1;
            //直到凑成taget
            if(backtrack(nums,end-1,k,used,cur+nums[i],target))
            {
                return true;
            }
            //执行到这里，肯定是当前的选择没有匹配成功了
            used[i]=0;

            while (i > 0 && nums[i - 1] == nums[i]) {
                i--;
            };
        }
        return false;
    }
    //方法一
//    //将第index个球放到桶里
//    public boolean backTrack(int[] nums,int[] buckets,int index)
//    {
//        if(index<0)
//        {
//            return true;
//        }
//        //当前的球装到哪一个桶里
//        for (int i=0;i<buckets.length;i++)
//        {
//            if(buckets[i]==nums[index]||(buckets[i]-nums[index]>=nums[0]))
//            {
//                buckets[i]=buckets[i]-nums[index];
//                //当前的放进桶i后结果成立
//                if(backTrack(nums,buckets,index-1))
//                {
//                    return true;
//                };
//                //当前的放进桶i后结果不成立，继续下一个球
//                buckets[i]=buckets[i]+nums[index];
//            }
//        }
//        return false;
//    }
    @Override
    public void test() {

    }
}
