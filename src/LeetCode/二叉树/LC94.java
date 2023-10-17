package LeetCode.二叉树;

import LeetCode.Base.LeetCodeBase;
import LeetCode.Common.Node;
import LeetCode.Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC94 implements LeetCodeBase
{
    List<Integer> result=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root)
    {
        backTrack(root);
        return result;

    }
    public void backTrack(TreeNode node)
    {
        if(node==null)
        {
            return;
        }
        if(node.left!=null)
        {
            backTrack(node.left);
        }
        result.add(node.val);
        if(node.right!=null)
        {
            backTrack(node.right);
        }
    }
    @Override
    public void test()
    {

    }
}
