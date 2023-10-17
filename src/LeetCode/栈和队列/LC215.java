package LeetCode.栈和队列;

import LeetCode.Base.LeetCodeBase;

import java.util.PriorityQueue;

public class LC215 implements LeetCodeBase
{
    public int findKthLargest(int[] nums, int k)
    {
        PriorityQueue<Integer> queue=new PriorityQueue<>((a,b)->{return b-a;});
        for (int i:nums)
        {
            queue.add(i);
        }
        for (int i=1;i<k;i++)
        {
            queue.poll();
        }
        return queue.poll();

    }
    @Override
    public void test() {

    }
}
