package LeetCode.链表;
import LeetCode.Common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class LC234
{
    public boolean isPalindrome(ListNode head)
    {
        List<Integer> list=new ArrayList<>();
        ListNode p=head;
        while (p!=null)
        {
            list.add(p.val);
            p=p.next;
        }
        int i=0,j=list.size()-1;
        while (i<=j)
        {
            if(!list.get(i).equals(list.get(j)))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;

    }
}
