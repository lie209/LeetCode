package LeetCode.二分法;

import LeetCode.Base.LeetCodeBase;

public class LC34 implements LeetCodeBase
{
    public int[] searchRange(int[] nums, int target)
    {
        //超出时间限制
//        int i=0;
//        int j=nums.length-1;
//        while (i<=j)
//        {
//            if(nums[i]<target)
//            {
//                i++;
//            }
//        }
//        while (j>=i)
//        {
//            if(nums[j]>target)
//            {
//                j--;
//            }
//        }
//        if(i>j)
//        {
//            return new int[]{-1,-1};
//        }
//        else
//        {
//            return new int[]{i,j};
//        }

        //第二种方法，二分法============================
        int i=0;
        int j=nums.length-1;
        int k=-1;
        while (i<=j) {
            int mid = (i + j) / 2;
            if (nums[mid] < target) {
                i = mid + 1;
            } else if(nums[mid] > target)
            {
                j=mid-1;
            }
            else if(nums[mid]==target)
            {
                k=mid;
                break;
            }
        }
        //序列中没有等于target的值
        if(k==-1)
        {
            return new int[]{-1,-1};
        }
        i=k;
        j=k;
        while(i>=0&&nums[i]==target)
        {
            i--;
        }
        while (j<=nums.length-1&&nums[j]==target)
        {
            j++;
        }
        return new int[]{i+1,j-1};
    }

    @Override
    public void test() {

    }
}
