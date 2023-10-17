package LeetCode.动态规划;

import LeetCode.Base.LeetCodeBase;

import java.util.*;

public class LC139 implements LeetCodeBase
{
    boolean result=false;
    HashSet<String> set=new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict)
    {
//        backTrack(s,"",wordDict);
//        return result;
        Set<String> set=new HashSet<>(wordDict);
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for (int i=1;i<=s.length();i++)
        {
            for (int j=0;j<i;j++)
            {
                //当前字符串前一部分存在且后续的也存在，当前就是 true
                if(dp[j]&&set.contains(s.substring(j,i)))
                {
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
//    public void backTrack(String target,String cur,List<String> wordDict)
//    {
//        if(set.contains(cur))
//        {
//            return;
//        }
//        if(cur.length()>target.length())
//        {
//            return;
//        }
//        if(!target.substring(0,cur.length()).equals(cur))
//        {
//            set.add(cur);
//            return;
//        }
//        if(cur.equals(target))
//        {
//            result=true;
//        }
//        if(result)
//        {
//            return;
//        }
//        for (int i=0;i<wordDict.size();i++)
//        {
//            backTrack(target,cur+wordDict.get(i),wordDict);
//        }
//    }
    @Override
    public void test()
    {
        System.out.println(wordBreak("leetcode",new ArrayList<>(Arrays.asList("leet", "code"))));
    }


}
