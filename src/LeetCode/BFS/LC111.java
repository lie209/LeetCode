package LeetCode.BFS;

import LeetCode.Common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC111
{
    public int minDepth(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        return taversal(root);
    }

    public  int taversal(TreeNode root)
    {
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty())
        {
            int size=queue.size();
            for (int i=0;i<size; i++)
            {
                TreeNode node=queue.poll();
                //向周围扩散====================
                if(node.left==null && node.right==null)
                {
                    return depth;
                }
                if (node.left!=null)
                {
                    queue.add(node.left);
                }
                if(node.right!=null)
                {
                    queue.add(node.right);
                }
                //========================
            }
            depth++;
        }
        return depth;
    }
}
