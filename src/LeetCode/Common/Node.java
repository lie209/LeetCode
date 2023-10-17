package LeetCode.Common;

import java.util.LinkedList;
import java.util.Queue;

public class Node{
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public static Node breadthFirstTrees(int[] list)
    {
        LinkedList<Node> queue=new LinkedList<>();
        Queue<Node> integerQueue= new LinkedList<>();
        for (int i:list)
        {
            integerQueue.offer(new Node(i));
        }
        Node treeNode=integerQueue.poll();
        queue.offer(treeNode);
        while (!queue.isEmpty())
        {
            Node node=queue.poll();
            if(!integerQueue.isEmpty())
            {
                node.left=integerQueue.poll();
                queue.offer(node.left);
            }
            if(!integerQueue.isEmpty())
            {
                node.right=integerQueue.poll();
                queue.offer(node.right);
            }
        }
        return treeNode;
    }
}