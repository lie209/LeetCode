package LeetCode.未分类;

import LeetCode.Base.LeetCodeBase;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class LC720 implements LeetCodeBase
{
    public String longestWord(String[] words)
    {
        Arrays.sort(words);
        HashSet<String> set=new HashSet<>();
        String result="";
        for (String i:words)
        {
            if(i.length()==1||set.contains(i.substring(0,i.length()-1)))
            {
                set.add(i);
                if(result.length()<i.length())
                {
                    result=i;
                }
                else if(result.length()==i.length())
                {
                    result=result.compareTo(i)<0?result:i;
                }
            }
        }
        return result;
    }
    @Override
    public void test()
    {
//        System.out.println(longestWord(new String[]{"w","wo","wor","worl", "world"}));
        System.out.println(longestWord(new String[]{"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"}));

    }
}
