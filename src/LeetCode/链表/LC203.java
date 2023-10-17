package LeetCode.链表;

import LeetCode.Base.LeetCodeBase;
import LeetCode.Common.ListNode;

import javax.print.attribute.HashPrintRequestAttributeSet;
import java.util.ArrayList;
import java.util.List;

public class LC203 implements LeetCodeBase
{
    public ListNode removeElements(ListNode head, int val)
    {
        if(head==null)
        {
            return null;
        }
        ListNode prev=new ListNode();
        prev.next=null;
        ListNode h=prev;
        ListNode p=head;
        while (p!=null)
        {
            if(p.val!=val)
            {
                prev.next=p;
                prev=p;
            }
            p=p.next;
        }
        prev.next=null;
        return h.next;
    }

    @Override
    public void test() {
        int[] list=new int[]{1};
        ListNode head=new ListNode(list[0]);
        ListNode h= head;
        for (int i=1;i<list.length;i++)
        {
            h.next=new ListNode(list[i]);
            h=h.next;
        }
        h= removeElements(head, 2);
        while (h!=null)
        {
            System.out.println(h.val);
            h=h.next;
        }
    }
}
