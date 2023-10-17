package LeetCode.二叉树;

import LeetCode.Common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC199
{

    public List<Integer> rightSideView(TreeNode root)
    {
        List<Integer> result=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            int size=queue.size();
            for (int i=0;i<size;i++)
            {
                TreeNode node=queue.poll();
                if(i==size-1)
                {
                    result.add(node.val);
                }
                if(node.left!=null)
                {
                    queue.add(node.left);
                }
                if(node.right!=null)
                {
                    queue.add(node.right);
                }
            }
        }
        return result;
    }

}
