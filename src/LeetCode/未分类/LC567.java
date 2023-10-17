package LeetCode.未分类;

import LeetCode.Base.LeetCodeBase;

import java.util.HashMap;
import java.util.List;

public class LC567 implements LeetCodeBase
{
    public boolean run(String s2,String s1)
    {
        if(s1.length()>s2.length())
        {
            return false;
        }
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++)
        {
            char current=s1.charAt(i);
            if(map1.containsKey(current))
            {
                map1.replace(current, map1.get(current)+1);
            }
            else
            {
                map1.put(current, 1);
                map2.put(current, 0);
            }
        }
        int left = 0;

        while (left <=s2.length()-s1.length())
        {
            int right = left+s1.length()-1;
            int valid=0;
            HashMap<Character,Integer> map= (HashMap<Character, Integer>) map2.clone();
            for (int i = left; i <= right; i++)
            {
                char current = s2.charAt(i);
                if(map.containsKey(current))
                {
                    map.replace(current, map.get(current)+1);
                    if(map.get(current).equals(map1.get(current)))
                    {
                        valid++;
                        if(valid==map1.size())
                        {
                            return true;
                        }
                    }
                }
            }
            left++;
        }
        return false;
    }

    @Override
    public void test() {

    }
}
