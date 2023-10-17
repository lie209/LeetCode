package LeetCode.数据结构设计;

import LeetCode.Base.LeetCodeBase;

import java.util.*;

public class LC380 implements LeetCodeBase
{
    class RandomizedSet {
        HashMap<Integer,Integer> hashMap;
        List<Integer> list;
        int length;

        public RandomizedSet() {
            this.hashMap=new HashMap<>();
            this.list=new ArrayList<>();
            this.length=0;
        }

        public boolean insert(int val)
        {
            if(!hashMap.containsKey(val))
            {
                list.add(val);
                hashMap.put(val, length);
                length++;
                return true;
            }
            return false;
        }

        public boolean remove(int val)
        {
            if(hashMap.containsKey(val))
            {
                //目标值
                int index=hashMap.get(val);
                list.set(index,list.get(length-1));
                hashMap.replace(list.get(index), index);
                list.remove(length-1);
                length--;
                hashMap.remove(val);
                return true;
            }
            return false;

        }

        public int getRandom()
        {
            int index=new Random().nextInt(length);
            return this.list.get(index);
        }
    }

    @Override
    public void test() {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(0);
        randomizedSet.insert(1);
        randomizedSet.remove(0);
        randomizedSet.insert(2);
        randomizedSet.remove(1);
        randomizedSet.getRandom();
    }
}
