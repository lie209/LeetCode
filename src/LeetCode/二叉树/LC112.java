package LeetCode.二叉树;

import LeetCode.Base.LeetCodeBase;
import LeetCode.Common.TreeNode;

import javax.swing.*;

public class LC112 implements LeetCodeBase
{
    boolean result=false;
    public boolean hasPathSum(TreeNode root, int targetSum)
    {
        if(root==null)
        {
            return result;
        }
        backTrack(root, 0, targetSum);
        return result;
    }

    public void backTrack(TreeNode node,int cur,int target)
    {
        if(node==null||result==true)
        {
            return;
        }
        cur=cur+node.val;
        if(cur==target&&node.left==null&&node.right==null)
        {
            result=true;
        }
        backTrack(node.left,cur,target);
        backTrack(node.right,cur,target);
    }
    @Override
    public void test() {

    }
}
