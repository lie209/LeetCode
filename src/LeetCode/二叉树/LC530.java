package LeetCode.二叉树;

import LeetCode.Base.LeetCodeBase;
import LeetCode.Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC530 implements LeetCodeBase
{
    List<Integer> list=new ArrayList<>();
    public int getMinimumDifference(TreeNode root)
    {
        dfs(root);
        int i=0,j=1;
        int res=Integer.MAX_VALUE;
        while (j<list.size())
        {
            res=Math.min(res,list.get(j)-list.get(i));
            i++;
            j++;
        }
        return res;
    }
    public void dfs(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
    @Override
    public void test() {

    }
}
