package LeetCode.动态规划;

import LeetCode.Base.LeetCodeBase;

import java.util.ArrayList;
import java.util.List;

public class LC118 implements LeetCodeBase
{
    public List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> first=new ArrayList<>();
        first.add(1);
        result.add(first);
        for(int i=2;i<numRows;i++)
        {
            List<Integer> list=new ArrayList<>();
            list.add(1);
            List<Integer> preList=result.get(result.size()-1);
            for (int j=0;j<preList.size()-1;j++)
            {
                list.add(preList.get(j)+preList.get(j+1));
            }
            list.add(1);
            result.add(list);
        }
        return result;
    }

    @Override
    public void test() {

    }
}
