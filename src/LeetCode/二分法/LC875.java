package LeetCode.二分法;

import LeetCode.Base.LeetCodeBase;

public class LC875 implements LeetCodeBase
{
    public int run(int[] piles,int h)
    {
        //low和high代表速度，最小是1
        int low = 1,high =0;
        for (int pile:piles)
        {
            high=Math.max(pile, high);
        }
        int res = high;
        while (low < high)
        {
            int speed=low+(high-low)/2;
            long time=getTime(piles, speed);
            //如果当前速度可以吃完，改变上界
            if(time<=h)
            {
                res=speed;
                high=speed;
            }
            //当前速度吃不完，增加下界
            if(time>h)
            {
                low=speed+1;
            }
        }
        return res;

    }

    //以速度speed吃香蕉耗费的时间
    public long getTime(int[] piles,int speed)
    {
        long time = 0;
        for (int pile : piles) {
            int curTime = (pile + speed - 1) / speed;
            time += curTime;
        }
        return time;
    }

    @Override
    public void test()
    {
        System.out.println(run(new int[]{312884470},
        968709470));

    }
}
