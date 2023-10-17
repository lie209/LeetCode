package LeetCode.未分类;

import LeetCode.Base.LeetCodeBase;
import LeetCode.Common.ListNode;

public class LC206 implements LeetCodeBase
{
    public ListNode run(ListNode head)
    {
        if(head==null)
        {
            return null;
        }
        int[] nodes=new int[5000];
        int i=0;
        ListNode p=head;
        while (p!=null)
        {
            nodes[i]=p.val;
            p=p.next;
            i++;
        }
        int left=0,right = i-1;
        int temp=0;
        while (left <=right)
        {
            temp=nodes[left];
            nodes[left]=nodes[right];
            nodes[right]=temp;
            left++;
            right--;
        }
        int j=0;
        p=head;
        while (j<i)
        {
            p.val = nodes[j];
            p=p.next;
            j++;
        }
        return head;
    }

    public ListNode run1(ListNode head)
    {
        if(head==null||head.next==null)
        {
            return head;
        }
        ListNode pre=run1(head.next);
        head.next.next=head;
        head.next=null;
        return pre;
    }

    @Override
    public void test() 
    {
        int[] tests=new int[]{1,2,3,4};
        ListNode node = new ListNode(1);
        ListNode p=node;
        for (int i = 1; i < tests.length; i++)
        {
            ListNode temp=new ListNode(tests[i]);
            p.next=temp;
            p=temp;
        }
        p=run1(node);
        while (p!=null)
        {
            System.out.println(p.val);
            p=p.next;
        }

    }
}
