package LeetCode.回溯法;

import LeetCode.Base.LeetCodeBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15 implements LeetCodeBase
{
    //方法一，回溯法，超时===========================================================
//    List<List<Integer>>  result=new ArrayList<>();
//    int[] used;
//    public List<List<Integer>> threeSum(int[] nums)
//    {
//        Arrays.sort(nums);
//        used=new int[nums.length];
//        backtrack(nums,new ArrayList<>(),0,0);
//        return result;
//    }
//
//    public void backtrack(int[] nums,List<Integer> list,int cur,int index)
//    {
//        if(list.size()==3&&cur==0)
//        {
//            result.add(new ArrayList<>(list));
//            return;
//        }
//        for (int i=index;i<nums.length;i++)
//        {
//            if(used[i]==0)
//            {
//                used[i]=1;
//                cur=cur+nums[i];
//                list.add(nums[i]);
//                backtrack(nums,list,cur,i+1);
//                list.remove(list.size()-1);
//                cur=cur-nums[i];
//                used[i]=0;
//            }
//            while (i+1<nums.length&&nums[i]==nums[i+1])
//            {
//                i++;
//            }
//        }
//    }

    //方法二，双指针法=====================
    public List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++)
        {
            //从小到大，最小的大于0了，肯定无解了
            if(nums[i]>0)
            {
                break;
            }
            while (i-1>=0&&i<nums.length&&nums[i-1]==nums[i])
            {
                i++;
            }
            int l=i+1;
            int r=nums.length-1;
            while (l<r)
            {

                int num=nums[i]+nums[l]+nums[r];
                if(num==0)
                {
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    result.add(list);
                    //排除重复的
                    while (l+1<nums.length&&nums[l]==nums[l+1])
                    {
                        l++;
                    }
                    while (r-1>i&&nums[r]==nums[r-1])
                    {
                        r--;
                    }
                    l++;
                    r--;
                }else
                {
                    if(num>0)
                    {
                        r--;
                    }
                    else
                    {
                        l++;
                    }
                }

            }
        }
        return result;

    }
    @Override
    public void test()
    {
//        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(threeSum(new int[]{0,0,0}));
//        System.out.println(threeSum(new int[]{0,1,1}));
    }
}
