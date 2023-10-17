package LeetCode.未分类;

import LeetCode.Base.LeetCodeBase;

import java.util.HashSet;

public class LC128 implements LeetCodeBase
{

    public int longestConsecutive(int[] nums)
    {
        //方法一，超时===================
        //最长连续序列，从头到尾加入到集合中，保证不重复，然后在当前数的值处向左右扩充，获得结果，多做了很多无用的操作
//        int result=0;
//        int count=1;
//        HashSet<Integer> set=new HashSet<>();
//        for (int i=0;i<nums.length;i++)
//        {
//            if(set.contains(nums[i]))
//            {
//                continue;
//            }
//            set.add(nums[i]);
//            count=1;
//            int cur=nums[i];
//
//            while (set.contains(cur+1))
//            {
//                count++;
//                cur++;
//            }
//            cur=nums[i];
//            while (set.contains(cur-1))
//            {
//                count++;
//                cur--;
//            }
//            result=Math.max(result,count);
//        }
//        return result;
        int result=0;
        int count=1;
        HashSet<Integer> set=new HashSet<>();
        for (int i:nums)
        {
            set.add(i);
        }
        for (int i:set)
        {
            int cur=i;
            count=1;
            //保证当前元素前面的数不存在，当前元素是最长序列的起点
            if(!set.contains(cur-1))
            {
                while (set.contains(cur+1))
                {
                    count++;
                    cur++;
                }
            }
            result=Math.max(count,result);
        }
        return result;
    }
    @Override
    public void test()
    {
//        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));

    }
}
