package LeetCode.链表;

import LeetCode.Base.LeetCodeBase;
import LeetCode.Common.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC148 implements LeetCodeBase
{
    public ListNode sortList(ListNode head)
    {
        List<Integer> list=new ArrayList<>();
        ListNode p=head;
        while (p!=null)
        {
            list.add(p.val);
            p=p.next;
        }
        List<Integer> list1=list.stream().sorted().toList();
        p=head;
        for (int i:list1)
        {
            p.val=i;
            p=p.next;
        }
        return head;
    }
    @Override
    public void test()
    {
        ListNode pre=ListNode.contructNodeList(new int[]{4,2,1,3});
        ListNode.printListNode(pre);
        System.out.println();
        ListNode.printListNode(sortList(pre));

    }
}
