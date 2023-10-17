package LeetCode.栈和队列;

import LeetCode.Base.LeetCodeBase;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LC347 implements LeetCodeBase
{
    public int[] topKFrequent(int[] nums, int k)
    {
        Arrays.sort(nums);
        int i=0;
        int j=0;
        PriorityQueue<int[]> queue=new PriorityQueue<>((int[] a,int[] b)->{return b[1]-a[1];});
        while (i<nums.length)
        {
            j=i;
            int count=0;
            while (j<nums.length&&nums[j]==nums[i])
            {
                count++;
                j++;
            }
            queue.add(new int[]{nums[i],count});
            i=j;
        }
        int[] result=new int[k];
        for (int l=0;l<k;l++)
        {
            result[l]=queue.poll()[0];
        }
        return result;

    }
    @Override
    public void test()
    {
        for (int i:topKFrequent(new int[]{1,1,1,2,2,3}, 2))
        {
            System.out.print(i+" ");
        }

    }
}
