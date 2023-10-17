package LeetCode.二叉树;

import LeetCode.Common.TreeNode;

public class LC111
{
    public int minDepth(TreeNode root)
    {

        return taversal(root);
    }
    public int taversal(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }

        if(root.left==null && root.right!=null)
        {
             return taversal(root.right)+1;
        }
        if(root.left!=null&&root.right==null)
        {
            return taversal(root.left)+1;
        }
        if(root.left!=null && root.right!=null)
        {
            return Math.min(taversal(root.left)+1,taversal(root.right)+1);
        }
        return 0;
    }
}
