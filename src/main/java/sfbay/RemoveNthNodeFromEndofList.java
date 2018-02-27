package sfbay;

//1->2->3->4->5

public class RemoveNthNodeFromEndofList {
    static public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null) return null;

        ListNode slow = head;

        ListNode fast = head;

        for (int i = 1; i <= n;i++) {
            if (fast != null)
                fast = fast.next;
            else
                return null;
        }

        if (fast == null)
            return head.next;
        while(fast.next!=null) {
                fast = fast.next;
                slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }
    public static void main(String ...s) {
        ListNode head = new ListNode(1);

        head.add(2).add(3).add(4).add(5);
        removeNthFromEnd(head, 5);
        System.out.print(head);
    }
}
 class ListNode {
      int val;
     ListNode next;
     ListNode(int x) { val = x; }

     ListNode add(int x) {
         next = new ListNode(x);
         return next;
     }

     @Override
     public String toString() {
         if (next != null)
             return val + "->" + next.toString();
         return "" + val;
     }
 }
