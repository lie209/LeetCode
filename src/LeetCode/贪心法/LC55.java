package LeetCode.贪心法;

import LeetCode.Base.LeetCodeBase;

import javax.xml.transform.stax.StAXResult;
import java.util.HashMap;

public class LC55 implements LeetCodeBase
{
    HashMap<Integer,Boolean> map=new HashMap<>();
    public boolean canJump(int[] nums)
    {
        int cover=0;
        //维护一个最长可到达距离，如果当前下标大于最大可到达距离，则返回false
        for (int i=0;i<nums.length;i++)
        {
            if(i>cover)
            {
                return false;
            }
            cover=Math.max(cover,i+nums[i]);
            if(cover>=nums.length-1)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public void test()
    {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
//        System.out.println(canJump(new int[]{3,2,1,0,4}));
        System.out.println(canJump(new int[]{2,0}));
        System.out.println(canJump(new int[]{5,9,3,2,1,0,2,3,3,1,0,0}));

    }
}
