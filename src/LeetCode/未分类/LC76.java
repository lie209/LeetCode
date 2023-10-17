package LeetCode.未分类;

import java.util.HashMap;
import java.util.Set;

public class LC76
{
    public String run(String s,String t)
    {
        if(s.length()<t.length())
        {
            return "";
        }
        if(s.length()==1)
        {
            if(s.equals(t))
            {
                return s;
            }
            else
            {
                return "";
            }
        }
        HashMap<Character,Integer> sMap = new HashMap<>();
        HashMap<Character,Integer> tMap = new HashMap<>();
        //初始化t中的所需字符数
        for (int i = 0;i<t.length();i++)
        {
            if(tMap.containsKey(t.charAt(i)))
            {
                tMap.replace(t.charAt(i), tMap.get(t.charAt(i))+1);
            }
            else
            {
                tMap.put(t.charAt(i), 1);
                sMap.put(t.charAt(i), 0);
            }
        }
        int valid=0;
        boolean flag=false;
        int a=tMap.size();
        int left=0, right=0;
        int minLen=Integer.MAX_VALUE;
        int resultLeft=0,resultRight=0;
        while (right<s.length())
        {
            char current = s.charAt(right);
            if(sMap.containsKey(current))
            {
                sMap.replace(current, sMap.get(current)+1);
                if(sMap.get(current).equals(tMap.get(current)))
                {
                    valid++;
                    if(valid==a)
                    {
                        //left收缩
                        while (valid==a)
                        {
                            char current1=s.charAt(left);
                            if(sMap.containsKey(current1))
                            {
                                sMap.replace(current1, sMap.get(current1)-1);
                                if(sMap.get(current1)<tMap.get(current1))
                                {
                                    valid--;
                                    left++;
                                    break;
                                }
                            }
                            left++;
                        }
                        if(right-left+2<minLen)
                        {
                            flag=true;
                            minLen = right-left + 2;
                            resultLeft=left-1;
                            resultRight=right;
                        }
                    }
                }
            }
            right++;
        }
        if(flag)
        {
            return s.substring(resultLeft,resultRight+1);
        }
        else
        {
            return "";
        }

    }

}
