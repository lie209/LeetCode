package LeetCode.未分类;

import LeetCode.Base.LeetCodeBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC49 implements LeetCodeBase
{
    List<List<String>> result=new ArrayList<>();
    public List<List<String>> groupAnagrams(String[] strs)
    {

        HashMap<String,List<String>> hashMap=new HashMap<>();
        for (String s:strs)
        {
            long count=1;
            char[] c=s.toCharArray();
            Arrays.sort(c);
            String key=String.valueOf(c);
            List<String> list=hashMap.getOrDefault(key,new ArrayList<>());
            list.add(s);
            hashMap.put(key,list);
        }
        for (String i:hashMap.keySet())
        {
            result.add(hashMap.get(i));
        }
        return result;
    }
    @Override
    public void test()
    {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
