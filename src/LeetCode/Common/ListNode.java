package LeetCode.Common;

public class ListNode
{
     public int val;
     public ListNode next;
     public ListNode() {}
     public ListNode(int val) { this.val = val; }
     public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

     public static ListNode contructNodeList(int[] list)
     {
          ListNode result=new ListNode();
          ListNode p=result;
          for (int i:list)
          {
               p.next=new ListNode(i);
               p=p.next;
          }
          return result.next;
     }

     public static void printListNode(ListNode node)
     {
          ListNode p=node;
          while (p!=null)
          {
               System.out.print(p.val+" ");
               p=p.next;
          }
     }
}
