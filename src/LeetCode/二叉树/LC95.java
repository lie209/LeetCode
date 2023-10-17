package LeetCode.二叉树;

import LeetCode.Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC95
{
    List<TreeNode> list=new ArrayList<>();
    public List<TreeNode> generateTrees(int n)
    {

        traversal(1,n);
        return list;
    }

    public TreeNode traversal(int n,int m)
    {
        if(n>m)
        {
            return null;
        }
        if(m==n)
        {
            return new TreeNode(n);
        }

        for (int i = n; i <=m; i++) {
            TreeNode left=traversal(n,i-1);
            TreeNode right=traversal(i+1,m);
            TreeNode root=new TreeNode(i);
            root.left=left;
            root.right=right;
            list.add(root);
        }
        return null;
    }
}
