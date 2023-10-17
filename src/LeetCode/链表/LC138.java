package LeetCode.链表;

import LeetCode.Common.Node;

import java.util.HashMap;

public class LC138
{
    public Node copyRandomList(Node head)
    {
        //新老节点建立映射，然后重新建立关系
        HashMap<Node,Node> map=new HashMap<>();
        Node p=head;
        while (p!=null)
        {
            map.put(p,new Node(p.val));
            p=p.next;
        }
        Node result=map.get(head);
        Node q=result;
        p=head;
        while (p!=null)
        {
            q.next=map.get(p.next);
            q.random=map.get(p.random);
            q=q.next;
            p=p.next;
        }
        return result;
    }
}
