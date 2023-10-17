package LeetCode.链表;

import LeetCode.Common.ListNode;

public class LC141
{
    //一个走一步，一个走两步，如果相遇了，则存在环
    public boolean hasCycle(ListNode head)
    {
        if(head==null)
        {
            return false;
        }
        ListNode p=head,q=head;
        while (p.next!=null&&q.next!=null&&q.next.next!=null)
        {
            p=p.next;
            q=q.next.next;
            if(q==p)
            {
                return true;
            }
        }
        return false;
    }

}
