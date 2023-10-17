package LeetCode.回溯法;

import LeetCode.Base.LeetCodeBase;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LC77 implements LeetCodeBase
{
    List<List<Integer>> reault=new ArrayList<>();

    int[] used;
    public List<List<Integer>> combine(int n, int k)
    {
        used=new int[n];
        int[] nums=new int[n];
        for (int i=1;i<=n;i++)
        {
            nums[i-1]=i;
        }
        backTrack(nums,k,new ArrayList<>(),0);
        return reault;

    }

    public void backTrack(int[] nums,int k,List<Integer> list,int index)
    {
        if(list.size()==k)
        {
            reault.add(new ArrayList<>(list));
            return;
        }
        for (int i=index;i<nums.length;i++)
        {
            list.add(nums[i]);
            backTrack(nums,k,list,i+1);
            list.remove(list.size()-1);
        }
    }
    @Override
    public void test()
    {
        List<List<Integer>> list=combine(4,2);
        System.out.println(list);

    }
}
