package LeetCode.数据结构设计;

import LeetCode.Base.LeetCodeBase;

import java.util.*;

public class LC710 implements LeetCodeBase
{
    class Solution
    {
        HashMap<Integer,Integer> hashMap;
        int bound;
        public Solution(int n, int[] blacklist)
        {
            bound=n-blacklist.length;
            hashMap=new HashMap<>();
            HashSet<Integer> set=new HashSet<>();
            for (int i :blacklist)
            {
                set.add(i);
            }
            //指向边界值外部不在blacklist中的值
            int outBound=bound;
            for(int i :blacklist)
            {
                if(i<bound)
                {
                    while (set.contains(outBound))
                    {
                        outBound++;
                    }
                    hashMap.put(i,outBound);
                    outBound++;
                }
            }
        }

        public int pick()
        {
            Random random=new Random();
            int index=random.nextInt(bound);
            return hashMap.getOrDefault(index, index);
        }
    }
    @Override
    public void test()
    {
        Solution solution = new Solution(4, new int[]{0,3});
        System.out.println(solution.pick());
        System.out.println(solution.pick());
        System.out.println(solution.pick());
        System.out.println(solution.pick());
        System.out.println(solution.pick());
        System.out.println(solution.pick());
        System.out.println(solution.pick());

    }
}
