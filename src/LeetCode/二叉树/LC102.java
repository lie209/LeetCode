package LeetCode.二叉树;

import LeetCode.Common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC102
{
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        if(root==null)
        {
            return result;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            int size=queue.size();
            List<Integer> list=new ArrayList<>();
            for (int i=0;i<size;i++)
            {
                TreeNode node=queue.poll();
                list.add(node.val);
                if(node.left!=null)
                {
                    queue.add(node.left);
                }
                if(node.right!=null)
                {
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
