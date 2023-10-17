package LeetCode.二叉树;

import LeetCode.Base.LeetCodeBase;
import LeetCode.Common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LC1302 implements LeetCodeBase
{
    public int deepestLeavesSum(TreeNode root)
    {
        if(root.left==null&&root.right==null)
        {
            return root.val;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int count=0;
        int result=0;
        while (!queue.isEmpty())
        {
            count=0;
            int size=queue.size();
            System.out.println("size:"+size);
            for (int i=0;i<size;i++)
            {
                TreeNode node=queue.poll();
                System.out.println(node.val);
                count=count+node.val;
                if(node.left!=null)
                {
                    queue.add(node.left);
                }
                if(node.right!=null)
                {
                    queue.add(node.right);
                }
            }
            result=count;
        }
        return result;
    }
    @Override
    public void test() {

    }
}
