package LeetCode.回溯法;

import LeetCode.Base.LeetCodeBase;

import java.util.ArrayList;
import java.util.List;

public class LC22 implements LeetCodeBase
{
    List<String> result=new ArrayList<>();
    public List<String> generateParenthesis(int n)
    {
        backTrack("",n,0,0);
        return result;
    }

    public void backTrack(String cur,int n,int left,int right)
    {
        if(left==n&&right==n)
        {
            result.add(cur);
            return;
        }
        //规律：左括号数目大于等于右括号数目
        if(left<right)
        {
            return;
        }
        if(left<n)
        {
            backTrack(cur+"(",n,left+1,right);
        }
        if(right<n)
        {
            backTrack(cur+")",n,left,right+1);
        }
    }


    @Override
    public void test()
    {
        System.out.println(generateParenthesis(3));
    }
}
