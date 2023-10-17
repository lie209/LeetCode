package LeetCode.数据结构设计;

import LeetCode.Base.LeetCodeBase;

import java.util.PriorityQueue;

public class LC295 implements LeetCodeBase
{
    class MedianFinder {

        PriorityQueue<Integer> queue1;
        PriorityQueue<Integer> queue2;
        int mid;
        public MedianFinder() {

//            小顶堆，放比中位数大的数
            this.queue1=new PriorityQueue<>((a,b)->(a-b));
//            大顶堆，放比中位数小的数
            this.queue2=new PriorityQueue<>((a,b)->(b-a));

        }

        public void addNum(int num)
        {
            //如果两个堆长度相等
            if(queue1.size()==queue2.size())
            {
                //先放到下面这个堆中排序，然后放到上面
                queue2.offer(num);
                queue1.offer(queue2.poll());
                return;
            }
            //如果长度不等
            if(queue1.size()!=queue2.size())
            {
                //先放到上面这个堆排序，然后加入下面这个堆
                queue1.offer(num);
                queue2.offer(queue1.poll());
                return;
            }
        }

        public double findMedian()
        {
            //题目中说至少有一个元素
            if(queue1.size()==queue2.size())
            {
                return (queue1.peek()+queue2.peek())/2.0;
            }
            else
            {
                return queue1.peek();
            }


        }
    }
    @Override
    public void test()
    {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        System.out.println(medianFinder.findMedian());
         // 返回 1.5 ((1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        System.out.println( medianFinder.findMedian());
       // return 2.0


    }
}
