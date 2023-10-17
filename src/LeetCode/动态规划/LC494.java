package LeetCode.动态规划;

import LeetCode.Base.LeetCodeBase;

import java.util.List;

public class LC494 implements LeetCodeBase
{
    //回溯法，超时了
//    int result;
//    List<List<Character>> lists=new ArrayList<>();
//    public int findTargetSumWays(int[] nums, int target)
//    {
//        backTrack(target,0,nums,0,new ArrayList<>());
//        return result;
//
//    }
//
//    public void backTrack(int target,int curr,int[] nums,int index,List<Character> list)
//    {
//        if(list.size()==nums.length&&target==curr)
//        {
//            result++;
//            lists.add(new ArrayList<>(list));
//            return;
//        }
//        for (int i=index;i<nums.length;i++)
//        {
//            list.add('+');
//            backTrack(target,curr+nums[i],nums,i+1,list);
//            list.remove(list.size()-1);
//            list.add('-');
//            backTrack(target,curr-nums[i],nums,i+1,list);
//            list.remove(list.size()-1);
//        }
//        return;
//    }

    int result=0;
    public int findTargetSumWays(int[] nums, int target)
    {

        //转化为背包问题，设有x个数前面为+，y个数前面为-
        //则有，x+y=sum,x-y=target
        int sum=0;
        for (int i:nums)
        {
            sum+=i;
        }
        if((sum+target)%2!=0)
        {
            return 0;
        }
        target=(sum+target)/2;
        if (target<0)
        {
            return 0;
        }
        //前I个物品中选取物品，使得元素和为j
        int[][] dp=new int[nums.length+1][target+1];
        for (int i=0;i<nums.length+1;i++)
        {
            dp[i][0]=1;
        }
        for (int i=1;i<=nums.length;i++)
        {
            for (int j=0;j<=target;j++)
            {
                if(nums[i-1]>j)
                {
                    dp[i][j]=dp[i-1][j];
                }
                else {
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-nums[i-1]];
                }

            }
        }
        return dp[nums.length][target];
    }

    public void backTrack(int[] nums, int target, int index,int cur)
    {
        if(target==cur)
        {
            result++;
            return;
        }
        for (int i=index;i<nums.length;i++)
        {
            backTrack(nums,target,i+1,cur+nums[i]);
        }
    }

    @Override
    public void test()
    {
        System.out.println(findTargetSumWays(new int[]{100},-200));

    }
}
