package LeetCode.数据结构设计;

import LeetCode.Base.LeetCodeBase;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class LC460  implements LeetCodeBase
{
    class LFUCache {

        LinkedHashMap<Integer,Integer> caches=new LinkedHashMap<>();
        HashMap<Integer,Integer> keysCounts=new HashMap<>();
        HashMap<Integer, LinkedHashSet<Integer>> count2keys =new HashMap<>();
        int capacity;
        public LFUCache(int capacity) {
            this.capacity=capacity;
        }

        public int get(int key)
        {
            if(caches.containsKey(key))
            {
                int count=keysCounts.get(key);
                keysCounts.replace(key,count+1);
                count2keys.get(count).remove(key);
                if(count2keys.containsKey(count+1))
                {
                    count2keys.get(count+1).add(key);
                }
                else
                {
                    count2keys.put(count+1, new LinkedHashSet<>());
                    count2keys.get(count+1).add(key);
                }
                return caches.get(key);
            }
            else
            {
                return -1;
            }

        }

        public void put(int key, int value)
        {
            if(caches.containsKey(key))
            {
                caches.replace(key,value);
                //访问次数加一
                int count=keysCounts.get(key);
                keysCounts.replace(key, count+1);
                count2keys.get(count).remove(key);
                if(count2keys.containsKey(count+1))
                {
                    count2keys.get(count+1).add(key);
                }
                else
                {
                    count2keys.put(count+1, new LinkedHashSet<>());
                    count2keys.get(count+1).add(key);
                }
            }
            else
            {
                //没有满
                if(caches.size()<this.capacity)
                {
                    caches.put(key, value);
                    keysCounts.put(key, 1);
                    if(count2keys.containsKey(1))
                    {
                        count2keys.get(1).add(key);
                    }
                    else
                    {
                        count2keys.put(1, new LinkedHashSet<>());
                        count2keys.get(1).add(key);
                    }
                }
                //满了
                else
                {
                    //最小的访问次数
                    int min=0;
                    for(int i:count2keys.keySet())
                    {
                        if(count2keys.get(i).size()!=0)
                        {
                            min=i;
                            break;
                        }
                    }
                    int minKey=count2keys.get(min).iterator().next();
                    caches.remove(minKey);
                    count2keys.get(min).remove(minKey);
                    keysCounts.remove(minKey);
                    caches.put(key, value);
                    keysCounts.put(key, 1);
                    count2keys.get(1).add(key);
                }
            }
        }
    }

    @Override
    public void test() {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
        lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        System.out.println(lfu.get(1));;      // 返回 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        System.out.println(lfu.get(2));;      // 返回 -1（未找到）
        System.out.println(lfu.get(3));;      // 返回 3
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        System.out.println(lfu.get(1));     // 返回 -1（未找到）
        System.out.println(lfu.get(3));      // 返回 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        System.out.println(lfu.get(4));      // 返回 4

    }
}
