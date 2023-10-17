package LeetCode.二叉树;

import LeetCode.Base.LeetCodeBase;
import LeetCode.Common.Node;
import LeetCode.Common.TreeNode;

import java.awt.image.renderable.RenderableImage;
import java.util.LinkedList;
import java.util.Queue;

public class LC116 implements LeetCodeBase
{


    public Node connect(Node root)
    {
        if (root==null)
        {
            return null;
        }
        traverse(root.left,root.right);
        return root;
    }

    public void traverse(Node left,Node right)
    {
        if (left == null || right == null) {
            return;
        }
            left.next = right;
            traverse(left.left, left.right);
            traverse(left.right, right.left);
            traverse(right.left, right.right);
            return;
    }
    public Node run(Node root)
    {
        if(root==null)
        {
            return null;
        }
        Queue<Node> queue1=new LinkedList<>();
        queue1.offer(root);
        Queue<Node> queue2=new LinkedList<>();
        while (!queue1.isEmpty()||!queue2.isEmpty())
        {
            while (!queue1.isEmpty())
            {
                //完美二叉树所以这么处理
                Node node=queue1.poll();
                node.next=queue1.peek();
                //完美二叉树，有left必有right
                if (node.left!=null)
                {
                    queue2.offer(node.left);
                    queue2.offer(node.right);
                }
            }
            while (!queue2.isEmpty())
            {
                Node node=queue2.poll();
                node.next=queue2.peek();
                if(node.left!=null)
                {
                    queue1.offer(node.left);
                    queue1.offer(node.right);
                }
            }
        }
        return root;
    }


    @Override
    public void test ()
    {
        Node node=Node.breadthFirstTrees(new int[]{
                1,2,3,4,5,6,7
        });
        run((Node)node);

    }
}
