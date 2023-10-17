package LeetCode.二叉树;

import LeetCode.Base.LeetCodeBase;
import LeetCode.Common.TreeNode;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.List;

public class LC501 implements LeetCodeBase
{
    TreeNode pre=null;
    List<Integer> list=new ArrayList<>();
    int res=0;
    int count=0;
    public int[] findMode(TreeNode root)
    {
        if(root.left==null&&root.right==null)
        {
            return new int[]{root.val};
        }
        dfs(root);
        int[] result=new int[list.size()];
        for(int i=0;i<list.size();i++)
        {
            result[i]=list.get(i);
        }
        return result;
    }

    public void dfs(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        dfs(root.left);
        //如果是第一个元素
        if(pre==null)
        {
            count=1;
            list.add(root.val);
        }
        if(pre!=null)
        {
            if(pre.val==root.val)
            {
                count++;
                if(count==res)
                {
                    list.add(root.val);
                }
                if(count>res)
                {
                    res=count;
                    list.clear();
                    list.add(root.val);
                }

            }
            else
            {
                count=1;
            }
        }
        dfs(root.right);
    }


    @Override
    public void test() {

    }
}
