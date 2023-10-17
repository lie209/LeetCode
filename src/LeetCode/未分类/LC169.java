package LeetCode.未分类;

import LeetCode.Base.LeetCodeBase;

import java.util.HashMap;

public class LC169 implements LeetCodeBase
{
    public int majorityElement(int[] nums)
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        int target=nums.length/2;
        int count=0;
        for (int i:nums)
        {
            count=map.getOrDefault(i,0);
            count++;
            if(count>target)
            {
                return i;
            }
            map.put(i,count);
        }
        return 0;
    }

    @Override
    public void test() {
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}
