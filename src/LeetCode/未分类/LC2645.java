package LeetCode.未分类;

import LeetCode.Base.LeetCodeBase;

import java.util.HashMap;
import java.util.PriorityQueue;

public class LC2645 implements LeetCodeBase
{
    public int addMinimum(String word)
    {
        //寻找连续递增子数组的个数，乘以三补全，然后减去原来的，就是需要添加的字符串个数
        int count=0;
        for (int i=0;i<word.length();i++)
        {
            if(i+1<word.length()&&word.charAt(i+1)>word.charAt(i))
            {
                continue;
            }
            else
            {
                count++;
            }
        }
        return count*3-word.length();
    }
    @Override
    public void test()
    {
        System.out.println(addMinimum("a"));

    }
}
