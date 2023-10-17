package LeetCode.回溯法;

import LeetCode.Base.LeetCodeBase;

import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.List;

public class LC131 implements LeetCodeBase
{
    List<List<String>> result=new ArrayList<>();

    public List<List<String>> partition(String s)
    {
        backTrack(s,0,s.length(),new ArrayList<>());
        return result;
    }

    public void backTrack(String s,int cur,int targetN,List<String> list)
    {
        //当前长度与原字符串相同
        if(cur==targetN)
        {
            result.add(new ArrayList<>(list));
        }
        for (int i=1;i<=s.length();i++)
        {
            String temp=s.substring(0,i);
            if(isOk(temp))
            {
                //选取当前字符串
                list.add(temp);
                //对其余部分进行下一步分割
                backTrack(s.substring(i,s.length()),cur+temp.length(),targetN,list);
                list.remove(list.size()-1);
            }
        }
    }

    public boolean isOk(String s)
    {
        int i=0;
        int j=s.length()-1;
        while (i<=j)
        {
            if(s.charAt(i)!=s.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    @Override
    public void test()
    {
        System.out.println(partition("aab"));

    }
}
