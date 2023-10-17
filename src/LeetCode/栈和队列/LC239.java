package LeetCode.栈和队列;

import LeetCode.Base.LeetCodeBase;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class LC239 implements LeetCodeBase
{
    class MonotonicQueue
    {
        //队列最大值
        Deque<Integer> deque=new LinkedList<>();
        int front;
        void pop(int a)
        {
            if(!deque.isEmpty()&&deque.getFirst()==a)
            {
                deque.pollFirst();

            }
            front=deque.getFirst();

        }
        void push(int a)
        {
            while (!deque.isEmpty()&&deque.getLast()<a)
            {
                deque.pollLast();
            }
            deque.offerLast(a);
            front=deque.getFirst();
        }
        int getMax()
        {
            return front;
        }
        MonotonicQueue()
        {
        }
    }
    public int[] run(int[] nums,int k)
    {
        if(k==1)
        {
            return nums;
        }
        int[] results=new int[nums.length-k+1];
        MonotonicQueue monotonicQueue=new MonotonicQueue();
        for (int i = 0; i < k; i++)
        {
            monotonicQueue.push(nums[i]);
        }
        results[0]=monotonicQueue.getMax();
        for (int i = 1; i <= nums.length-k; i++)
        {
            monotonicQueue.pop(nums[i-1]);
            monotonicQueue.push(nums[i+k-1]);
            results[i]=monotonicQueue.getMax();
        }
        return results;
    }
    //优先级队列，超时了
    public int[] maxSlidingWindow(int[] nums,int k)
    {
        if(k==1)
        {
            return nums;
        }
        int[] results=new int[nums.length-k+1];
        PriorityQueue<Integer> queue=new PriorityQueue<>((Integer a, Integer b)->
        {
            return b-a;
        });
        for (int i = 0; i < k; i++)
        {
            queue.add(nums[i]);
        }
        results[0]=queue.peek();
        for (int i = 1; i <= nums.length-k; i++)
        {
            queue.remove(nums[i-1]);
            queue.offer(nums[i+k-1]);
            results[i]=queue.peek();
        }
        return results;

    }
    @Override
    public void test()
    {
        for (int i:run(new int[]{1,3,-1,-3,5,3,6,7}, 3))
        {
            System.out.print(i+" ");
        }

    }
}
