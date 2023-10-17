package LeetCode.链表;

import LeetCode.Base.LeetCodeBase;
import LeetCode.Common.ListNode;

public class LC2 implements LeetCodeBase
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode p=l1,q=l2;

        int temp=0;
        int val=0;
        ListNode result=new ListNode();
        ListNode r=result;
        while (p!=null&&q!=null)
        {
            val=p.val+q.val+temp;
            temp=val>=10?1:0;
            r.next=new ListNode(val>=10?val%10:val);
            r=r.next;
            p=p.next;
            q=q.next;
        }
        ListNode tempNode=p==null?q:p;
        while (tempNode!=null)
        {
            val=tempNode.val+temp;
            temp=val>=10?1:0;
            r.next=new ListNode(val>=10?val%10:val);
            r=r.next;
            tempNode=tempNode.next;
        }
        if(temp!=0)
        {
            r.next=new ListNode(temp);
        }
        return result.next;
    }

    @Override
    public void test()
    {
        ListNode list1=ListNode.contructNodeList(new int[]{9,9,9,9,9,9,9});
        ListNode list2=ListNode.contructNodeList(new int[]{9,9,9,9});
        ListNode.printListNode(addTwoNumbers(list1,list2));
    }
}
