package LeetCode.二叉树;

import LeetCode.Common.TreeNode;
import com.sun.source.tree.Tree;

public class LC701
{
    public TreeNode insertIntoBST(TreeNode root, int val)
    {
        if(root==null)
        {
            return new TreeNode(val);
        }
        insert(root,val);
        return root;
    }

    public void insert(TreeNode root,int val)
    {
        if(val>root.val)
        {
             if(root.right==null)
             {
                 root.right=new TreeNode(val);
                 return;
             }
             else
             {
                 insert(root.right, val);
             }
        }
        if(val<root.val)
        {
            if(root.left==null)
            {
                root.left=new TreeNode(val);
                return;
            }
            else insert(root.left,val);
        }
    }
}
