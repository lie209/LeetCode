package LeetCode.二叉树;

import java.util.HashMap;

public class LC96
{
    HashMap<Integer,Integer> map=new HashMap<>();
    //使用递归遍历多种可能性
    public int numTrees(int n) {
        if(n==0||n==1)
        {
            return 1;
        }
        //如果当前情况下map中有值，则直接返回，免得下一次查找
        if(map.containsKey(n))
        {
            return map.get(n);
        }
        int count=0;
        for (int i = 1; i <= n; i++)
        {
            int left=numTrees(i-1);
            int right=numTrees(n-i);
            count=left*right;
            map.put(n, count);
        }
        return count;
    }
}
