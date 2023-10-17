package LeetCode.未分类;

import LeetCode.Base.LeetCodeBase;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LC136 implements LeetCodeBase
{
    public int singleNumber(int[] nums)
    {
//        Arrays.sort(nums);
//        int count=1;
//        for (int i=0;i<nums.length;i++)
//        {
//           if(i+1<nums.length&&nums[i+1]==nums[i])
//           {
//               i=i+1;
//               continue;
//           }
//           else
//           {
//               return nums[i];
//           }
//        }
//        return nums[0];
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i:nums)
        {
            int count=map.getOrDefault(i,0);
            if(count+1==2)
            {
                map.remove(i);
                continue;
            }
            map.put(i,++count);
        }
        return (int)map.keySet().toArray()[0];
    }
    @Override
    public void test()
    {
        System.out.println(singleNumber(new int[]{4,1,2,1,2}));

    }
}
