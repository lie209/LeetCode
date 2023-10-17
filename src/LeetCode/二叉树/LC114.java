package LeetCode.二叉树;

import LeetCode.Base.LeetCodeBase;
import LeetCode.Common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC114 implements LeetCodeBase
{
    public void run(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        if(root.right==null&& root.left==null)
        {
            return;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        preorderTraversal(root, queue);
        TreeNode p=root;
        while (!queue.isEmpty())
        {
            p.left=null;
            p.right=queue.poll();
            p=p.right;
        }
    }

    public void preorderTraversal(TreeNode root,Queue<TreeNode> queue)
    {
        if(root==null)
        {
            return;
        }
        queue.offer(root);
        preorderTraversal(root.left,queue);
        preorderTraversal(root.right,queue);
    }

    @Override
    public void test() {

    }
}
