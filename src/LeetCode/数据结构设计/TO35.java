package LeetCode.数据结构设计;

import LeetCode.Base.LeetCodeBase;
import LeetCode.Common.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
public class TO35 implements LeetCodeBase
{
    //使用哈希表在源节点和新节点之间做一个映射，一开始想着存到列表里，然后映射坐标，题解是直接在节点之间建立映射，这种方法确实巧妙很多
    public Node copyRandomList(Node head)
    {
        if (head == null)
            return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr!= null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        Node newHead = map.get(head);
        Node p=newHead;
        while (curr!= null)
        {
            p.next = map.get(curr.next);
            p.random=map.get(curr.random);
            p=p.next;
            curr=curr.next;
        }
        return newHead;
    }
    @Override
    public void test() {

    }
}
