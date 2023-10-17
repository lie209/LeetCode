package LeetCode.数组;

import LeetCode.Base.LeetCodeBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LCR011 implements LeetCodeBase
{
    public int findMaxLength(int[] nums)
    {
        //将0转换为-1
        for (int i=0;i<nums.length;i++)
        {
            nums[i]=nums[i]==0?-1:1;
        }
        HashMap<Integer, Integer> map=new HashMap<>();
        //前缀和为0，下标为-1
        map.put(0,-1);
        int prenums=0;
        int result=0;
        for (int i=0;i<nums.length;i++)
        {
            prenums=prenums+nums[i];
            //如果不存在，就存储前缀和为prenums最左边的下标
            if(!map.containsKey(prenums))
            {
                map.put(prenums, i);
            }
            //如果存在相同前缀和，证明中间就有相同数量的-1和1抵消了，中间下标的差值就是长度，-1，-1，1，1，长度为3-（-1）=4
            else
            {
                result=Math.max(result,i-map.get(prenums));
            }
        }
        return result;
    }

    @Override
    public void test()
    {
        System.out.println(findMaxLength(new int[]{0,1}));

    }
}
