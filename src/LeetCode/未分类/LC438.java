package LeetCode.未分类;

import LeetCode.Base.LeetCodeBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC438 implements LeetCodeBase
{
    public List<Integer> findAnagrams(String s, String p)
    {
        List<Integer> result=new ArrayList<>();
        if(p.length()>s.length())
        {
            return result;
        }
        HashMap<Character,Integer> need=new HashMap<>();
        HashMap<Character,Integer> has=new HashMap<>();
        for (char i:p.toCharArray())
        {
            has.put(i,0);
            int count= need.getOrDefault(i,0);
            need.put(i,count+1);
        }

        for (int i=0;i<p.length();i++)
        {
            if(has.containsKey(s.charAt(i)))
            {
                has.replace(s.charAt(i),has.get(s.charAt(i))+1);
            }
        }
        if(isOk(need,has))
        {
            result.add(0);
        }
        if(has.containsKey(s.charAt(0)))
        {
            has.replace(s.charAt(0), has.get(s.charAt(0))-1);
        }

        for (int i=1;i<=s.length()-p.length();i++)
        {
            int j=i+p.length()-1;
            if(has.containsKey(s.charAt(j)))
            {
                int count = has.getOrDefault(s.charAt(j), 0);
                has.replace(s.charAt(j), count+1);
                if(isOk(need,has))
                {
                    result.add(i);

                }
            }
            if(has.containsKey(s.charAt(i)))
            {
                has.replace(s.charAt(i),has.get(s.charAt(i))-1);
            }

        }
        return result;
    }

    public boolean isOk(HashMap<Character,Integer> map1,HashMap<Character,Integer> map2)
    {
        for (char i:map1.keySet())
        {
            if(!map2.containsKey(i))
            {
                return false;
            }
            //Integer在-127和+127之间可以使用==来比较大小，超出这个范围后比较的是内存地址了，所以需要equals来比较大小
            if(!map1.get(i).equals(map2.get(i)))
            {
                return false;
            }
        }
        return true;
    }


    @Override
    public void test() {
        List<Integer> result = findAnagrams("abc","a");
        for(int i:result)
        {

            System.out.print(i+" ");
        }
    }
}
