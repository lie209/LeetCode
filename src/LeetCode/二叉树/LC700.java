package LeetCode.二叉树;

import LeetCode.Common.TreeNode;

public class LC700
{
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null)
        {
            return null;
        }
        if(val==root.val)
        {
            return root;
        }
        if(val>root.val)
        {
            return searchBST(root.right, val);
        }
        if(val<root.val)
        {
            return searchBST(root.left,val);
        }
        return null;
    }
}
