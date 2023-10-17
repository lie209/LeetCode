package LeetCode.二叉树;

import LeetCode.Base.LeetCodeBase;
import LeetCode.Common.TreeNode;

public class LC226 implements LeetCodeBase
{
    public TreeNode invertTree(TreeNode root)
    {
        if(root==null)
        {
            return root;
        }
        if(root.left!=null&&root.right==null)
        {
            root.right=root.left;
            root.left=null;
            invertTree(root.right);
            return root;
        }
        if(root.left==null&&root.right!=null)
        {
            root.left=root.right;
            root.right=null;
            invertTree(root.left);
            return root;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode node=root.left;
        root.left=root.right;
        root.right=node;
        return root;
    }

    @Override
    public void test() {

    }
}
