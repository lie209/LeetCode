package LeetCode.栈和队列;

import LeetCode.Base.LeetCodeBase;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class LC503 implements LeetCodeBase
{

    //原版
    public int[] nextGreaterElements(int[] nums) {
        int[] nums1=new int[nums.length*2];
        System.arraycopy(nums, 0, nums1, 0, nums.length);
        System.arraycopy(nums, 0, nums1, nums.length, nums.length);
        int[] results=new int[nums.length];
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        //默认值设置为-1
        Arrays.fill(results, -1);
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        for (int i = 1; i < nums1.length; i++)
        {
            if(nums1[i]>nums1[stack.peek()])
            {
                while (!stack.isEmpty()&&nums1[i]>nums1[stack.peek()])
                {
                    results[stack.peek()>=nums.length?stack.peek()-nums.length:stack.peek()]=nums1[i];
                    stack.pop();
                }
                stack.push(i);
            }
            else
            {
                stack.push(i);
            }

        }
        return results;
    }
    //优化版，使用取余而不是创建一个两倍长度数组，来实现循环数组
    public int[] run(int[] nums)
    {
        int n=nums.length;
        int[] results=new int[nums.length];
        //默认值设置为-1
        Arrays.fill(results, -1);
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        for (int i = 1; i < n*2; i++)
        {
            int num=nums[i%n];
            if(num>nums[stack.peek()%n])
            {
                while (!stack.isEmpty()&&num>nums[stack.peek()])
                {
                    results[stack.peek()%n]=num;
                    stack.pop();
                }
                stack.push(i%n);
            }
            else
            {
                stack.push(i%n);
            }

        }
        return results;

    }
    @Override
    public void test()
    {
        for (int i:run(new int[]{4,1,2,3}))
        {
            System.out.println(i);
        }

    }
}
