package LeetCode.回溯法;

import LeetCode.Base.LeetCodeBase;

import java.util.ArrayList;
import java.util.List;

public class LC216 implements LeetCodeBase
{
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n)
    {
        backTrack(n,1,0,new ArrayList<>(),k);
        return result;

    }

    public void backTrack(int target,int begin,int cur,List<Integer> list,int k)
    {
        if(cur==target&&list.size()==k)
        {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i=begin;i<=9;i++)
        {
            if(cur+i<=target)
            {
                list.add(i);
                backTrack(target,i+1,cur+i,list ,k);
                list.remove(list.size()-1);
            }
        }

    }
    @Override
    public void test()
    {
        List<List<Integer>> list=combinationSum3(3,7);
        System.out.println(list);

    }
}
