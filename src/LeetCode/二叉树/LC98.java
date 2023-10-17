package LeetCode.二叉树;

import LeetCode.Common.TreeNode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class LC98
{
    List<Integer> list=new ArrayList<>();
    public boolean isValidBST(TreeNode root)
    {
        if(root==null)
        {
            return false;
        }
        traversal(root);
        for (int i = 0; i < list.size()-1; i++) {
            if(list.get(i)>list.get(i+1))
            {
                return false;
            }
        }
        return true;


    }
    public void traversal(TreeNode root)
    {
        if (root==null)
        {
            return;
        }
        traversal(root.left);
        list.add(root.val);
        traversal(root.right);
    }
}
