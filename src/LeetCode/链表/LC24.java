package LeetCode.链表;

import LeetCode.Base.LeetCodeBase;
import LeetCode.Common.ListNode;

public class LC24 implements LeetCodeBase
{
    public ListNode swapPairs(ListNode head)
    {
        if(head==null||head.next==null)
        {
            return head;
        }
        ListNode h=new ListNode();
        h.next=head;
        ListNode pre=h;
        ListNode p=h.next;
        ListNode result=h.next.next;
        while (p!=null&&p.next!=null)
        {
            ListNode next=p.next;
            pre.next=p.next;
            p.next=next.next;
            pre.next.next=p;
            pre=p;
            p=p.next;
        }
        return result;
    }
    @Override
    public void test()
    {
        ListNode head=ListNode.contructNodeList(new int[]{1,2,3});
        ListNode.printListNode(swapPairs(head));

    }
}
