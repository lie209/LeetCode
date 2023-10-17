package LeetCode.栈和队列;

import LeetCode.Base.LeetCodeBase;

import java.beans.Introspector;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class LC496 implements LeetCodeBase
{
    public int[] run(int[] nums1,int[] nums2)
    {
        int[] results=new int[nums1.length];
        Arrays.fill(results, -1);
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int i = 0; i < nums1.length; i++)
        {
            hashMap.put(nums1[i],i);
        }
        Stack<Integer> stack=new Stack<>();
        stack.push(nums2[0]);
        for (int i = 1; i < nums2.length; i++)
        {
            if(nums2[i]>stack.peek())
            {
                while (!stack.isEmpty()&&nums2[i]>stack.peek())
                {
                    if(hashMap.containsKey(stack.peek()))
                    {
                        results[hashMap.get(stack.peek())]=nums2[i];
                    }
                    stack.pop();
                }
                stack.push(nums2[i]);
            }
            else
            {
                stack.push(nums2[i]);
            }

        }
        return results;
    }

    @Override
    public void test()
    {
        for (int i:run(new int[]{1,3,5,2,4}, new int[]{6,5,4,3,2,1,7}))
        {
            System.out.println(i);
        }

    }
}
