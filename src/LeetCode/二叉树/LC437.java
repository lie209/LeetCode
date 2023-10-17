package LeetCode.二叉树;

import LeetCode.Base.LeetCodeBase;
import LeetCode.Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC437 implements LeetCodeBase
{
    int result=0;
    public int pathSum(TreeNode root, int targetSum)
    {
        backTrack(root,targetSum);
        return result;
    }
    public void backTrack(TreeNode node,int target)
    {
        if(node==null)
        {
            return;
        }
        backTrack(node.left,target);
        backTrackPath(node,node.val,target);
        backTrack(node.right,target);
    }

    public void backTrackPath(TreeNode node, int cur, int target)
    {
        if(cur==target)
        {
            result++;

        }
        if(node.left!=null)
        {

            backTrackPath(node.left,cur+node.left.val,target);

        }
        if(node.right!=null)
        {

            backTrackPath(node.right,cur+node.right.val,target);

        }
    }
    @Override
    public void test() {

    }
}
